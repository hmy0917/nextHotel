package com.future.nexthotel.web.model;

/**
 * @author HaoMingYao (haomingyao@gotokeep.com)
 * @date 2019/1/10
 * @time 11:23 AM
 **/
public final class RequestContextHolder {
    private static final ThreadLocal<RequestContext> REQUEST_CONTEXT = new ThreadLocal();

    private RequestContextHolder() {}

    public static RequestContext get() {
        return (RequestContext) REQUEST_CONTEXT.get();
    }

    public static void set(RequestContext context) {
        REQUEST_CONTEXT.set(context);
    }

    public static void remove() {
        REQUEST_CONTEXT.remove();
    }
}
