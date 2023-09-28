package com.zfinance.repositories.actions;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zfinance.orm.actions.Actions;

public interface ActionsRepository extends CassandraRepository<Actions, String> {

	@Query("SELECT * FROM zfin_actions " + "ALLOW FILTERING")
	List<Actions> findAllByFilter();

	@Query("SELECT * FROM zfin_actions " + "WHERE id = :p_actionId  " + "ALLOW FILTERING")
	List<Actions> findAllById(@Param("p_actionId") String actionId);

}
