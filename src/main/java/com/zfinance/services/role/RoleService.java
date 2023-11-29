package com.zfinance.services.role;

import com.mongodb.DuplicateKeyException;
import com.zfinance.orm.role.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAll();
    Role findRoleById(String id) throws Exception;
    void save(Role role);
}
