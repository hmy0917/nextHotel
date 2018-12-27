package com.future.nexthotel.dao;

import com.future.nexthotel.model.domain.mongo.HotelUser;
import com.future.nexthotel.model.query.UserQuery;

/**
 * @author HaoMingYao (haomingyao@gotokeep.com)
 * @date 2018/12/26
 * @time 8:43 PM
 **/

public interface NextHotelUserDao {

    Boolean insert(HotelUser hotelUser);

    HotelUser findUser(UserQuery query);
}
