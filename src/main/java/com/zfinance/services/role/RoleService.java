package com.zfinance.services.role;

import java.util.List;

import com.zfinance.orm.role.Role;

public interface RoleService {
	List<Role> getAll();

	Role findRoleById(String id) throws Exception;

	void save(Role role);
}
