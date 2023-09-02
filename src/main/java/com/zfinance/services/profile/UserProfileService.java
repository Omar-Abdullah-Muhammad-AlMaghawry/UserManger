package com.zfinance.services.profile;

import com.zfinance.orm.profile.UserProfile;
import com.zfinance.orm.userdefinedtypes.UserAddress;
import com.zfinance.orm.userdefinedtypes.UserBusiness;
import com.zfinance.orm.userdefinedtypes.UserInfo;
import com.zfinance.orm.userdefinedtypes.UserSecurity;

public interface UserProfileService {

	public UserProfile getUserProfile(String userId);

	public void updateUserProfileInfo(String userId, UserInfo person);

	public void updateUserAddress(String userId, UserAddress address);

	public void updateUserBusiness(String userId, UserBusiness data);

	public void updateUserLogin(String userId, String login);

	public void updateUserSecurity(String userId, UserSecurity security);

	public UserProfile saveUserProfile(UserProfile userProfile);

}
