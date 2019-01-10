package com.future.nexthotel.exception;
import lombok.Data;
/**
 * @author HaoMingYao (haomingyao@gotokeep.com)
 * @date 2019/1/7
 * @time 6:45 PM
 **/
@Data
public class NextHotelException extends RuntimeException {
    protected int httpStatusCode;
    protected int errorCode;

    public NextHotelException(int httpStatusCode, int errorCode, String message) {
        super(message);
        this.httpStatusCode = httpStatusCode;
        this.errorCode = errorCode;
    }
    public NextHotelException(NextHotelErrorCode errorCode) {
        this(errorCode.getHttpStatus(), errorCode.getCode(), errorCode.getMsg());
    }

}
