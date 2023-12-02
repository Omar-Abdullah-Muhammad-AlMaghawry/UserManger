package com.zfinance.dto.response.user;

import com.zfinance.orm.role.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RoleResponse {
   private List<Role> roles;
}
