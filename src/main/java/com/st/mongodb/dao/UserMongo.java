package com.st.mongodb.dao;

import com.st.mongodb.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMongo extends MongoRepository<User, String> {
    User findFirstByName(String name);

    User findUserFromName(String name);
}
