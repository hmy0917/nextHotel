package com.future.nexthotel.model.vo.response;

/**
 * @author HaoMingYao (haomingyao@gotokeep.com)
 * @date 2019/1/7
 * @time 5:42 PM
 **/
public class ResponseEntity {
    private boolean ok;
    private Object data;
    private int errorCode;
    private String text;

    public ResponseEntity(boolean ok, Object data, int errorCode, String text) {
        this.ok = ok;
        this.data = data;
        this.errorCode = errorCode;
        this.text = text;
    }

    public ResponseEntity(Boolean ok){
        this.ok = ok;
    }
    public ResponseEntity(Object data) {
        this.ok = true;
        this.data = data;
        this.errorCode = 200;
    }

    public ResponseEntity(int errorCode, String text) {
        this.ok = false;
        this.errorCode = errorCode;
        this.text = text;
    }
}
