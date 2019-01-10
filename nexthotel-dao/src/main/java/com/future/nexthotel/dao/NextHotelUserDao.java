package com.future.nexthotel.dao;

import com.future.nexthotel.model.domain.mongo.role.HotelUser;
import com.future.nexthotel.model.query.UserQuery;

/**
 * @author HaoMingYao (haomingyao@gotokeep.com)
 * @date 2018/12/26
 * @time 8:43 PM
 **/

public interface NextHotelUserDao {

    /**
     * 添加用户
     * @param hotelUser
     * @return
     */
    Boolean insert(HotelUser hotelUser);

    /**
     * 查找用户信息
     * @param query
     * @return
     */
    HotelUser findUser(UserQuery query);
}
