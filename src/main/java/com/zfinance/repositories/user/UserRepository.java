package com.zfinance.repositories.user;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zfinance.orm.user.User;

public interface UserRepository extends MongoRepository<User, String> {

}
