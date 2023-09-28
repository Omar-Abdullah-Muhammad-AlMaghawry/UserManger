package com.zfinance.repositories.actions;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zfinance.orm.actions.Actions;

public interface ActionsRepository extends MongoRepository<Actions, String> {

	List<Actions> findByActionId(String actionId);

}
