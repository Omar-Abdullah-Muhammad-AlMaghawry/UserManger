package com.zfinance.repositories.profile;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.zfinance.orm.profile.UserProfileDocument;

public interface UserProfileDocumentRepository extends CassandraRepository<UserProfileDocument, String> {

}
