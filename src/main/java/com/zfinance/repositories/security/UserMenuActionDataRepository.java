package com.zfinance.repositories.security;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zfinance.orm.security.UserMenuActionData;

public interface UserMenuActionDataRepository extends MongoRepository<UserMenuActionData, Long> {

	List<UserMenuActionData> findAllByUserIdAndMenuCodeAndModuleId(Long userId, String menuCode, Long moduleId);

	List<UserMenuActionData> findAllByUserIdAndMenuCodeAndModuleIdAndAction(Long userId, String menuCode, Long moduleId,
			String action);

}