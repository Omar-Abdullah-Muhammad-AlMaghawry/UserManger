package com.zfinance.repositories.user.profile;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zfinance.orm.profile.UserProfile;

public interface UserProfileRepository extends CassandraRepository<UserProfile, String> {

	@Query("SELECT * FROM zfin_user_profile " + " WHERE user_id = :p_user_id " + " ALLOW FILTERING ")
	UserProfile findByUserId(@Param("p_user_id") String userId);
}
