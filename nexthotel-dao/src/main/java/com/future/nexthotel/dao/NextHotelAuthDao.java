package com.future.nexthotel.dao;

import com.future.nexthotel.web.model.RoleBase;

/**
 * @author HaoMingYao (haomingyao@gotokeep.com)
 * @date 2019/1/9
 * @time 4:36 PM
 **/
public interface NextHotelAuthDao {

    /**
     * 通过电话获取角色信息
     * @param phone
     * @return
     */
    RoleBase findTypeName(String phone);
}
