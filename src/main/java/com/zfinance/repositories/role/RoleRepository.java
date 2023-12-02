package com.zfinance.repositories.role;

import com.zfinance.orm.role.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {
        public Role findRoleByName(String name);
}
