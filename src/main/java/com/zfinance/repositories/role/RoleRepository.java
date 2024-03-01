package com.zfinance.repositories.role;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.zfinance.orm.role.Role;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {
	public Role findRoleByName(String name);

	public Role findByCode(String code);
}
