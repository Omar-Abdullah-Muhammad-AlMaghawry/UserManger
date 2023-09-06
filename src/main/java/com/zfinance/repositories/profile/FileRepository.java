package com.zfinance.repositories.profile;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zfinance.orm.profile.File;

public interface FileRepository extends CassandraRepository<File, String> {

	@Query("SELECT * FROM zfin_file " + " WHERE owner_id = :p_owner_id " + " ALLOW FILTERING ")
	File findByOwnerId(@Param("p_owner_id") String ownerId);

}
