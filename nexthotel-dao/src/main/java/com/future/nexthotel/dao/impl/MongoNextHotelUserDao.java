package com.future.nexthotel.dao.impl;

import org.apache.commons.lang3.StringUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.future.nexthotel.dao.NextHotelUserDao;
import com.future.nexthotel.model.domain.mongo.role.HotelUser;
import com.future.nexthotel.model.query.UserQuery;
import com.mongodb.MongoException;



/**
 * @author HaoMingYao (haomingyao@gotokeep.com)
 * @date 2018/12/26
 * @time 9:11 PM
 **/
@Component
public class MongoNextHotelUserDao implements NextHotelUserDao {

    @Autowired
    MongoTemplate mongoTemplate;


    @Override
    public Boolean insert(HotelUser hotelUser) {
        if (hotelUser == null) {
            return false;
        }
        hotelUser.setCreateAt(System.currentTimeMillis());
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
        if (StringUtils.isNotBlank(userQuery.getCardId())) {
            query.addCriteria(Criteria.where("cardId").is(new ObjectId(userQuery.getCardId())));
        }
        if (StringUtils.isNotBlank(userQuery.getFirstName())) {
            query.addCriteria(Criteria.where("firstName").is(userQuery.getFirstName()));
        }
        if (StringUtils.isNotBlank(userQuery.getLastName())) {
            query.addCriteria(Criteria.where("lastName").is(userQuery.getLastName()));
        }
        if (StringUtils.isNotBlank(userQuery.getPhone())) {
            query.addCriteria(Criteria.where("phone").is(userQuery.getPhone()));
        }
        return mongoTemplate.findOne(query, HotelUser.class);
    }
}
