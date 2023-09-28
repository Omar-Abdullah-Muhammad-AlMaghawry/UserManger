package com.zfinance.repositories.profile;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zfinance.orm.profile.UserProfileDocument;

public interface UserProfileDocumentRepository extends MongoRepository<UserProfileDocument, String> {

}
