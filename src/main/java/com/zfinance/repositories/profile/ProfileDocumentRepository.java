package com.zfinance.repositories.profile;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zfinance.orm.profile.ProfileDocument;

public interface ProfileDocumentRepository extends MongoRepository<ProfileDocument, String> {

}
