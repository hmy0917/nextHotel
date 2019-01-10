package com.future.nexthotel.webapp.interceptor;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.future.nexthotel.dao.NextHotelAuthDao;
import com.future.nexthotel.exception.NextHotelErrorCode;
import com.future.nexthotel.exception.NextHotelException;
import com.future.nexthotel.model.vo.response.ResponseEntity;
import com.future.nexthotel.web.model.RequestContext;
import com.future.nexthotel.web.model.RequestContextHolder;
import com.future.nexthotel.web.model.RoleBase;
import com.future.nexthotel.webapp.annotation.AccessControl;

/**
 * @author HaoMingYao (haomingyao@gotokeep.com)
 * @date 2019/1/7
 * @time 6:04 PM
 **/
public class NextAccessControlInterceptor extends HandlerInterceptorAdapter {
    public static final String AUTH_HEADER_PARAM = "Authorization";

    private NextHotelAuthDao nextHotelAuthDao;

    public NextAccessControlInterceptor(NextHotelAuthDao nextHotelAuthDao) {
        this.nextHotelAuthDao = nextHotelAuthDao;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }


        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Annotation[] annotations = handlerMethod.getMethod().getAnnotations();
        AccessControl accessControl = null;
        for (Annotation annotation : annotations) {
            if (annotation.annotationType().equals(AccessControl.class)) {
                accessControl = (AccessControl) annotation;
                break;
            }
        }

        if (accessControl != null) {
            try {
                checkAuthentication(request, accessControl);
            } catch (NextHotelException ex) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.setContentType("application/json; charset=UTF-8");
                ResponseEntity responseEntity = new ResponseEntity(ex.getErrorCode(), ex.getMessage());
                response.getWriter().write(responseEntity.toString());
                return false;
            }
        }
        return true;
    }

    private void checkAuthentication(HttpServletRequest request, AccessControl accessControl) throws Exception {
        String authHeader = request.getHeader(AUTH_HEADER_PARAM);
        String phone = analysisPhone(authHeader);
        boolean flag = true;
        if (!accessControl.ignoreResources()) {
            RoleBase roleBase = nextHotelAuthDao.findTypeName(phone);
            if (roleBase == null) {
                throw new NextHotelException(NextHotelErrorCode.USER_NON_EXISTENT);
            }

            for (String owendResource : accessControl.allowResources()) {
                if (owendResource.equals(roleBase.getUserType())) {
                    flag = false;
                }
            }
            if (flag) {
                throw new NextHotelException(NextHotelErrorCode.USER_NO_AUTHORITY);
            }
            request.setAttribute("roleBase", roleBase);
            RequestContext context = new RequestContext(roleBase);
            RequestContextHolder.set(context);
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        RequestContextHolder.remove();
    }

    private String analysisPhone(String authHeader) throws Exception {
        if (StringUtils.isBlank(authHeader)) {
            throw new NextHotelException(NextHotelErrorCode.USER_NON_EXISTENT);
        }
        return authHeader.substring(2, 10);
    }
}
