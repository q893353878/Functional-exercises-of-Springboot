package com.st.mongodb.dao.impl;

import com.st.mongodb.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName UserMongoImpl
 * @Description TODO
 * @Author administrator
 * @Date 2019/1/7 0007 上午 10:29
 * @Version 1.0
 **/
@Repository
public class UserMongoImpl {
    @Autowired
    private MongoTemplate mongoTemplate;

    public User findUserFromName(String name){
        return mongoTemplate.findOne(Query.query(Criteria.where("name").is(name)), User.class);
    }
    public List<User> listUser(String name, String age) {
        return mongoTemplate.find(Query.query(Criteria.where("name").regex(name).and("age").gt(age)), User.class);
    }

    public void updateUser(String name, String id) {
        Update update = new Update();
        update.set("name", name);
        mongoTemplate.updateFirst(Query.query(Criteria.where("_id").is(id)), update, User.class);
    }

    public void removeUserById(String id) {
        mongoTemplate.remove(Query.query(Criteria.where("id").is(id)), User.class);
    }
}
