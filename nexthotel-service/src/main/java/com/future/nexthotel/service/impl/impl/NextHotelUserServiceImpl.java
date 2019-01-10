package com.future.nexthotel.service.impl.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.future.nexthotel.dao.NextHotelUserDao;
import com.future.nexthotel.dao.NextHotelUserRemarkDao;
import com.future.nexthotel.model.domain.mongo.UserRemark;
import com.future.nexthotel.model.domain.mongo.role.HotelUser;
import com.future.nexthotel.model.domain.mongo.role.HotelWorker;
import com.future.nexthotel.model.query.UserQuery;
import com.future.nexthotel.service.impl.NextHotelUserService;
import com.future.nexthotel.web.model.RequestContextHolder;

/**
 * @author HaoMingYao (haomingyao@gotokeep.com)
 * @date 2018/12/26
 * @time 9:16 PM
 **/
@Service
public class NextHotelUserServiceImpl implements NextHotelUserService {

    @Autowired
    private NextHotelUserDao hotelUserDao;

    @Autowired
    private NextHotelUserRemarkDao hotelUserRemarkDao;

    @Override
    public Boolean saveUser(HotelUser user) {
        return hotelUserDao.insert(user);
    }

    @Override
    public HotelUser findUser(UserQuery query) {
        return hotelUserDao.findUser(query);
    }

    @Override
    public Boolean remarkUser(String text, String userId) {
        HotelWorker worker = (HotelWorker) RequestContextHolder.get().getRoleBase();
        UserRemark remark = new UserRemark();
        remark.setWorkerId(worker.getWorkerId());
        remark.setUserId(userId);
        remark.setText(text);
        remark.setCreateAt(System.currentTimeMillis());
        return hotelUserRemarkDao.save(remark);
    }

    @Override
    public List<UserRemark> getRemarks(String userId) {
        if (StringUtils.isBlank(userId)) {
            return null;
        }
        return hotelUserRemarkDao.getReark(userId, "");
    }
}
