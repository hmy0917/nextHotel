package com.future.nexthotel.exception;

/**
 * @author HaoMingYao (haomingyao@gotokeep.com)
 * @date 2019/1/8
 * @time 11:32 AM
 **/
public enum NextHotelErrorCode {

    INTERNAL_SERVER_ERROR(500, 500000, "内部服务器错误"),

    PARAM_NOT_VALID(500, 501001, "参数不合法"),

    USER_NON_EXISTENT(401001, "用户不存在"),
    USER_PASSWORD_ERROR(401002, "用户密码错误"),
    USER_NO_AUTHORITY(401003, "用户没有权限");


    int httpStatus;
    int code;
    String msg;

    NextHotelErrorCode(int code, String msg) {
        // 业务逻辑错误的http status code默认为400
        this.httpStatus = 400;
        this.code = code;
        this.msg = msg;
    }

    NextHotelErrorCode(int httpStatus, int code, String msg) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.msg = msg;
    }


    public int getHttpStatus() {
        return httpStatus;
    }


    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
