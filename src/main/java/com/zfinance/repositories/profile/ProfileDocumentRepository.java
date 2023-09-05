package com.zfinance.repositories.profile;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.zfinance.orm.profile.ProfileDocument;

public interface ProfileDocumentRepository extends CassandraRepository<ProfileDocument, String> {

}
