package com.future.nexthotel.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.future.nexthotel.dao.NextHotelUserRemarkDao;
import com.future.nexthotel.model.domain.mongo.UserRemark;



/**
 * @author HaoMingYao (haomingyao@gotokeep.com)
 * @date 2019/1/10
 * @time 11:01 AM
 **/
@Component
public class MongoNextHotelUserRemarkDao implements NextHotelUserRemarkDao {

    @Autowired
    MongoTemplate mongoTemplate;


    @Override
    public boolean save(UserRemark userRemark) {
        if (userRemark == null) {
            return false;
        }
        try {
            mongoTemplate.save(userRemark);
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    @Override
    public List<UserRemark> getReark(String userId, String workerId) {
        Query query = new Query();
        if (StringUtils.isNotBlank(userId)) {
            query.addCriteria(Criteria.where("userId").is(userId));
        }
        if (StringUtils.isNotBlank(workerId)) {
            query.addCriteria(Criteria.where("workerId").is(workerId));
        }
        return mongoTemplate.find(query, UserRemark.class);
    }
}
