package com.zfinance.services.external;

import com.zfinance.orm.user.User;

public interface AuthManagerService {

	public void registerUser(User user);

	public String getUserIdFromToken(String token);

}
