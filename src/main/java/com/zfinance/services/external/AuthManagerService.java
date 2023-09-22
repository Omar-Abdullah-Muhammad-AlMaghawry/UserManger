package com.zfinance.services.external;

import com.zfinance.dto.response.user.UserRecord;
import com.zfinance.orm.user.User;

public interface AuthManagerService {

	public void registerUser(User user);

	public UserRecord getUserIdFromToken(String token);

}
