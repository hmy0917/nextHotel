package com.keep.kit.nexthotel.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keep.kit.nexthotel.service.impl.TestServiceImpl;

/**
 * Date: 2018/9/14
 * Time: 下午5:51
 *
 * @author sunnyxd (fanxiaodong@gotokeep.com)
 */
@RestController
public class TestController {

    @Autowired
    TestServiceImpl testService;

    @GetMapping("/hello")
    public String hello() {
        return "hello world123";
    }
}
