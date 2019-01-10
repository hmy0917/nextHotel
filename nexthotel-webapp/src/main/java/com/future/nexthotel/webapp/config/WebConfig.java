package com.future.nexthotel.webapp.config;

import org.springframework.aop.SpringProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.future.nexthotel.dao.NextHotelAuthDao;
import com.future.nexthotel.webapp.interceptor.NextAccessControlInterceptor;

/**
 * @author HaoMingYao (haomingyao@gotokeep.com)
 * @date 2019/1/9
 * @time 5:51 PM
 **/
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter implements SpringProxy {
    @Autowired
    private NextHotelAuthDao nextHotelAuthDao;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new NextAccessControlInterceptor(nextHotelAuthDao));
    }
}
