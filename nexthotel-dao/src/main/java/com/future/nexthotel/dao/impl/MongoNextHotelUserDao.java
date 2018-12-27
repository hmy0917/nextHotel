package com.future.nexthotel.dao.impl;

import org.apache.commons.lang3.StringUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.future.nexthotel.dao.NextHotelUserDao;
import com.future.nexthotel.model.domain.mongo.HotelUser;
import com.future.nexthotel.model.query.UserQuery;
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
    public HotelUser findUser(UserQuery userQuery) {
        if (userQuery == null) {
            return null;
        }
        Query query = new Query();
        if (StringUtils.isNotBlank(userQuery.getUserId())) {
            query.addCriteria(Criteria.where("_id").is(new ObjectId(userQuery.getUserId())));
        }
        if (StringUtils.isNotBlank(userQuery.getUserName())) {
            query.addCriteria(Criteria.where("username").is(userQuery.getUserName()));
        }
        return mongoTemplate.findOne(query, HotelUser.class);
    }
}
