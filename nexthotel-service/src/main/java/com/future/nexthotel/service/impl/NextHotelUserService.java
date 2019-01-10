package com.future.nexthotel.service.impl;

import java.util.List;

import com.future.nexthotel.model.domain.mongo.UserRemark;
import com.future.nexthotel.model.domain.mongo.role.HotelUser;
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

    /**
     * 备注用户信息
     * 
     * @param
     * @return
     */
    Boolean remarkUser(String text, String userId);

    /**
     * 查询用户备注信息
     * 
     * @param userId
     * @return
     */
    List<UserRemark> getRemarks(String userId);
}
