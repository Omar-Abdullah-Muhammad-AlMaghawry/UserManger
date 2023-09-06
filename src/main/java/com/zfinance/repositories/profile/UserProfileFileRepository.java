package com.zfinance.repositories.profile;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.zfinance.orm.profile.UserProfileFile;

public interface UserProfileFileRepository extends CassandraRepository<UserProfileFile, String> {

}
