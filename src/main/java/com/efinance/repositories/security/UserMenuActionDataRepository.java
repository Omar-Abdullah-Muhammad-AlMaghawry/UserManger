package com.efinance.repositories.security;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.efinance.orm.security.UserMenuActionData;

public interface UserMenuActionDataRepository extends JpaRepository<UserMenuActionData, Long> {

	List<UserMenuActionData> findAllByUserIdAndMenuCodeAndModuleId(Long userId, String menuCode, Long moduleId);

	List<UserMenuActionData> findAllByEmployeeIdAndMenuCodeAndModuleIdAndAction(Long employeeId, String menuCode,
			Long moduleId, String action);
}
