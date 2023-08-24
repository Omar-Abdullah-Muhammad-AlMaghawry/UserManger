package com.efinance.repositories.security;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.efinance.orm.security.UserMenuActionData;

public interface UserMenuActionDataRepository extends CassandraRepository<UserMenuActionData, Long> {

	List<UserMenuActionData> findAllByUserIdAndMenuCodeAndModuleId(Long userId, String menuCode, Long moduleId);

	List<UserMenuActionData> findAllByEmployeeIdAndMenuCodeAndModuleIdAndAction(Long employeeId, String menuCode,
			Long moduleId, String action);
}
