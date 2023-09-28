package com.zfinance.repositories.profile;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zfinance.orm.profile.UserProfile;

public interface UserProfileRepository extends MongoRepository<UserProfile, String> {

	UserProfile findByUserId(String userId);
}
