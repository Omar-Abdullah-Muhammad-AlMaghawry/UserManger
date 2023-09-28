package com.zfinance.repositories.profile;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zfinance.orm.profile.File;

public interface FileRepository extends MongoRepository<File, String> {

	File findByOwnerId(String ownerId);

}
