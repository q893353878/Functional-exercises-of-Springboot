package com.st.mongodb.service;

import com.st.mongodb.User;
import com.st.mongodb.dao.UserMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author administrator
 * @Date 2019/1/7 0007 上午 10:29
 * @Version 1.0
 **/
@Service
public class UserService {
    @Autowired
    private UserMongo userMongo;

    public User getUserById(String id)
    {
        return userMongo.findById(id).get();
    }

    public User getUserByName(String name)
    {
        return userMongo.findFirstByName(name);
    }

    public User findFromName(String name)
    {
        return userMongo.findUserFromName(name);
    }
}
