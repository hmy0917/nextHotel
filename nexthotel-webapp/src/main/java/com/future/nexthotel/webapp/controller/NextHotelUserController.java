package com.future.nexthotel.webapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.future.nexthotel.model.domain.mongo.role.HotelUser;
import com.future.nexthotel.model.query.UserQuery;
import com.future.nexthotel.model.vo.response.ResponseEntity;
import com.future.nexthotel.service.impl.NextHotelUserService;
import com.future.nexthotel.webapp.annotation.AccessControl;

/**
 * @author HaoMingYao (haomingyao@gotokeep.com)
 * @date 2018/12/26
 * @time 9:20 PM
 **/
@RestController
@RequestMapping(value = "/nexthotel/v1/user")
public class NextHotelUserController {

    @Autowired
    private NextHotelUserService nextHotelUserService;

    @AccessControl(allowResources = "customer")
    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity insert(@RequestBody @Valid HotelUser user) {
        return new ResponseEntity(nextHotelUserService.saveUser(user));
    }

    @AccessControl(allowResources = "customer")
    @GetMapping(value = "/info", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getUserInfo(@RequestBody UserQuery query) {

        return new ResponseEntity(nextHotelUserService.findUser(query));
    }

    @AccessControl(allowResources = "worker")
    @PostMapping(value = "/remark", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity remark(@RequestParam String text, @RequestParam String userId) {
        return new ResponseEntity(nextHotelUserService.remarkUser(text, userId));
    }

    @AccessControl(allowResources = "worker")
    @PostMapping(value = "/remark", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity remark(@RequestParam String userId) {
        return new ResponseEntity(nextHotelUserService.getRemarks(userId));
    }
}
