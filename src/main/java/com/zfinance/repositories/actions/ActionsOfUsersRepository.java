package com.zfinance.repositories.actions;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import com.zfinance.orm.actions.ActionsOfUsers;

public interface ActionsOfUsersRepository extends CassandraRepository<ActionsOfUsers, String> {

	@Query("SELECT * FROM zfin_actions_of_users " + "ALLOW FILTERING")
	List<ActionsOfUsers> findAllByFilter();

}
