package com.future.nexthotel.model.enums;

/**
 * @author HaoMingYao (haomingyao@gotokeep.com)
 * @date 2019/1/8
 * @time 12:13 PM
 **/
public enum UserType {
    /**
     * 顾客
     */
    CUSTOMER(1, "customer"),
    /**
     * 员工
     */
    WORKER(2, "worker"),
    /**
     * 管理员
     */
    ADMIN(3, "admin"),
    /**
     * 超级管理员
     */
    SUPER_ADMIN(4, "superAdmin");

    int typeNum;
    String typeName;

    UserType(int typeNum, String typeName) {
        this.typeNum = typeNum;
        this.typeName = typeName;
    }

    public int getTypeNum() {
        return typeNum;
    }

    public String getTypeName() {
        return typeName;
    }
}
