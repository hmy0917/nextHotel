package com.future.nexthotel.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.future.nexthotel.dao.NextHotelUserDao;
import com.future.nexthotel.model.domain.mongo.HotelUser;
import com.mongodb.MongoException;

/**
 * @author HaoMingYao (haomingyao@gotokeep.com)
 * @date 2018/12/26
 * @time 9:11 PM
 **/
@Repository
public class MongoNextHotelUserDao implements NextHotelUserDao {

    @Autowired
    MongoTemplate mongoTemplate;


    @Override
    public Boolean insert(HotelUser hotelUser) {
        if (hotelUser == null) {
            return false;
        }
        try {
            mongoTemplate.save(hotelUser);
        } catch (MongoException e) {
            return false;
        }
        return true;
    }

    @Override
    public void findUser() {

    }
}
