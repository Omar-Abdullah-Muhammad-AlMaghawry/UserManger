package com.zfinance.services.security;

import java.util.List;

import com.zfinance.dto.response.user.UserRecord;
import com.zfinance.dto.security.MenuHierarchy;
import com.zfinance.exceptions.BusinessException;
import com.zfinance.orm.security.UserMenuActionData;

public interface SecurityService {

	public UserRecord validateToken(String token);

	public List<UserMenuActionData> getUserMenuActions(Long userId, String menuCode);

	public boolean isUserMenuActionGranted(Long empId, String menuCode, String action);

	public List<MenuHierarchy> getUserActiveMenuHierarchy(Long userId, Integer menuType) throws BusinessException;

}
