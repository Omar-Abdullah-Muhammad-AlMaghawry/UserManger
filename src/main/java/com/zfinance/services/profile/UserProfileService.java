package com.zfinance.services.profile;

import com.zfinance.orm.profile.UserProfile;
import com.zfinance.orm.userdefinedtypes.user.UserAddress;
import com.zfinance.orm.userdefinedtypes.user.UserBusiness;
import com.zfinance.orm.userdefinedtypes.user.UserInfo;
import com.zfinance.orm.userdefinedtypes.user.UserSecurity;

public interface UserProfileService {

	public UserProfile getUserProfile(String userId);

	public void updateUserProfileInfo(String userId, UserInfo person);

	public void updateUserAddress(String userId, UserAddress address);

	public void updateUserBusiness(String userId, UserBusiness data);

	public void updateUserLogin(String userId, String login);

	public void updateUserSecurity(String userId, UserSecurity security);

	public UserProfile saveUserProfile(UserProfile userProfile);

	public void approveIdentification(String id);

	public void declineIdentification(String id);

	public void resetIdentification(String id);

}
