package com.efinance.services.security;

import java.util.List;

import com.efinance.dto.user.UserDto;
import com.efinance.orm.security.UserMenuActionData;

public interface SecurityService {

	public UserDto authenticate(String token);

	public List<UserMenuActionData> getUserMenuActions(Long userId, String menuCode);

	public boolean isUserMenuActionGranted(Long empId, String menuCode, String action);

}
