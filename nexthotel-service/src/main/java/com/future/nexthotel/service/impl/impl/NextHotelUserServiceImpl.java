package com.future.nexthotel.service.impl.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.future.nexthotel.dao.NextHotelUserDao;
import com.future.nexthotel.model.domain.mongo.HotelUser;
import com.future.nexthotel.service.impl.NextHotelUserService;
import org.springframework.stereotype.Service;

/**
 * @author HaoMingYao (haomingyao@gotokeep.com)
 * @date 2018/12/26
 * @time 9:16 PM
 **/
@Service
public class NextHotelUserServiceImpl implements NextHotelUserService {

    @Autowired
    private NextHotelUserDao hotelUserDao;

    @Override
    public Boolean saveUser(HotelUser user) {
        return hotelUserDao.insert(user);
    }
}
