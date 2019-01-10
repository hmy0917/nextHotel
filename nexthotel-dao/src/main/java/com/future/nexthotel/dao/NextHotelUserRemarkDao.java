package com.future.nexthotel.dao;

import java.util.List;

import com.future.nexthotel.model.domain.mongo.UserRemark;

/**
 * @author HaoMingYao (haomingyao@gotokeep.com)
 * @date 2019/1/10
 * @time 11:00 AM
 **/
public interface NextHotelUserRemarkDao {

    /**
     * 给用户备注
     *
     * @param userRemark
     * @return
     */
    boolean save(UserRemark userRemark);

    /**
     * 查询备注
     *
     * @param userId
     * @return
     */
    List<UserRemark> getReark(String userId, String workerId);
}
