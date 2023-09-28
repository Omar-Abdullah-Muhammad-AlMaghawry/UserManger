package com.zfinance.repositories.profile;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zfinance.orm.profile.UserProfileFile;

public interface UserProfileFileRepository extends MongoRepository<UserProfileFile, String> {

}
