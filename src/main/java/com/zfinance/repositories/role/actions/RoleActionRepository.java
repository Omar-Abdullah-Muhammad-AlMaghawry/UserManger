package com.zfinance.repositories.role.actions;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zfinance.orm.role.actions.RoleAction;

public interface RoleActionRepository extends MongoRepository<RoleAction, String> {

	List<RoleAction> findByName(String name);

	List<RoleAction> findByUserId(String userId);
}
