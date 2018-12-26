package com.future.nexthotel.webapp.controller;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.future.nexthotel.model.domain.mongo.HotelUser;
import com.future.nexthotel.service.impl.NextHotelUserService;

/**
 * @author HaoMingYao (haomingyao@gotokeep.com)
 * @date 2018/12/26
 * @time 9:20 PM
 **/
@RestController
@RequestMapping(value = "/nexthotel/v1/user")
public class NextHotelUserController {

    @Resource
    private NextHotelUserService nextHotelUserService;

    @ResponseBody
    @GetMapping(value = "/insert", produces = MediaType.APPLICATION_JSON_VALUE)
    public String insert(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "password", required = false, defaultValue = "") String password) {
        HotelUser user = new HotelUser();
        user.setUserName(name);
        user.setUserPassword(password);
        nextHotelUserService.saveUser(user);
        return user.toString();
    }
}
