package com.future.nexthotel.web.model;

import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HaoMingYao (haomingyao@gotokeep.com)
 * @date 2019/1/10
 * @time 11:24 AM
 **/
@Data
public class RequestContext {
    private RoleBase roleBase;
    private RequestContext.RequestHeader header;

    public RequestContext(RoleBase roleBase, Map<String, String> request) {
        this.roleBase = roleBase;
        this.header = this.buildHeader(request);
    }

    public RequestContext(RequestHeader header) {
        this.header = header;
    }

    public RequestContext(RoleBase roleBase) {
        this.roleBase = roleBase;
    }


    private RequestContext.RequestHeader buildHeader(Map<String, String> request) {
        RequestContext.RequestHeader header = new RequestHeader();
        header.setPhone(request.get("x-phone-num"));
        header.setWorkerNum(request.get("x-worker-id"));
        return header;
    }

    @Data
    @NoArgsConstructor
    public static class RequestHeader {
        private String phone;
        private String workerNum;
    }
}
