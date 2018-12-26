package com.future.nexthotel.service.impl;

import com.future.nexthotel.model.domain.mongo.HotelUser;

/**
 * @author HaoMingYao (haomingyao@gotokeep.com)
 * @date 2018/12/26
 * @time 9:15 PM
 **/
public interface NextHotelUserService {

    Boolean saveUser(HotelUser user);
}
