package com.future.nexthotel.dao;

import com.future.nexthotel.model.domain.mongo.HotelUser;

/**
 * @author HaoMingYao (haomingyao@gotokeep.com)
 * @date 2018/12/26
 * @time 8:43 PM
 **/

public interface NextHotelUserDao {

    Boolean insert(HotelUser hotelUser);

    void findUser();
}
