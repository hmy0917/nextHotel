package com.future.nexthotel.service.impl;

import com.future.nexthotel.model.domain.mongo.HotelUser;
import com.future.nexthotel.model.query.UserQuery;

/**
 * @author HaoMingYao (haomingyao@gotokeep.com)
 * @date 2018/12/26
 * @time 9:15 PM
 **/
public interface NextHotelUserService {

    /**
     * 保存用户信息
     * 
     * @param user
     * @return
     */
    Boolean saveUser(HotelUser user);

    /**
     * 查询用户信息
     * 
     * @param query
     * @return
     */
    HotelUser findUser(UserQuery query);
}
