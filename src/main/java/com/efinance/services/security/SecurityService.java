package com.efinance.services.security;

import java.util.List;

import com.efinance.dto.response.user.UserRecord;
import com.efinance.dto.security.MenuHierarchy;
import com.efinance.exceptions.BusinessException;
import com.efinance.orm.security.UserMenuActionData;

public interface SecurityService {

	public UserRecord validateToken(String token);

	public List<UserMenuActionData> getUserMenuActions(Long userId, String menuCode);

	public boolean isUserMenuActionGranted(Long empId, String menuCode, String action);

	public List<MenuHierarchy> getUserActiveMenuHierarchy(Long userId, Integer menuType) throws BusinessException;

}
