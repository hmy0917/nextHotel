package com.future.nexthotel.dao.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.future.nexthotel.dao.NextHotelAuthDao;
import com.future.nexthotel.model.domain.mongo.role.HotelAdmin;
import com.future.nexthotel.model.domain.mongo.role.HotelUser;
import com.future.nexthotel.model.domain.mongo.role.HotelWorker;
import com.future.nexthotel.web.model.RoleBase;

/**
 * @author HaoMingYao (haomingyao@gotokeep.com)
 * @date 2019/1/9
 * @time 4:37 PM
 **/
@Component
public class MongoNextHotelAuthDao implements NextHotelAuthDao {

    @Autowired
    MongoTemplate mongoTemplate;


    @Override
    public RoleBase findTypeName(String phone) {
        if (StringUtils.isBlank(phone)) {
            return null;
        }
        RoleBase roleBase;
        Query query = new Query();
        query.addCriteria(Criteria.where("phone").is(phone));
        roleBase = mongoTemplate.findOne(query, HotelUser.class);
        if (roleBase == null) {
            roleBase = mongoTemplate.findOne(query, HotelWorker.class);
            if (roleBase == null) {
                roleBase = mongoTemplate.findOne(query, HotelAdmin.class);
            }
        }
        return roleBase;
    }
}
