package com.zfinance.services.profile;

import com.zfinance.orm.profile.UserProfile;
import com.zfinance.orm.userdefinedtypes.user.UserAddress;
import com.zfinance.orm.userdefinedtypes.user.UserBusiness;
import com.zfinance.orm.userdefinedtypes.user.UserGeneralSetting;
import com.zfinance.orm.userdefinedtypes.user.UserIdentity;
import com.zfinance.orm.userdefinedtypes.user.UserInfo;
import com.zfinance.orm.userdefinedtypes.user.UserSecurity;

public interface UserProfileService {

	public UserProfile getUserProfileByUserId(String userId);

	public UserProfile updateUserProfileInfo(String userId, UserInfo person);

	public UserProfile updateUserAddress(String userId, UserAddress address);

	public UserProfile updateUserBusiness(String userId, UserBusiness data);

	public UserProfile updateUserIdentiy(String userId, UserIdentity identity);

	public UserProfile updateUserProfile(String userId, UserInfo person, UserAddress address, UserIdentity identity);

	public UserProfile updateUserLogin(String userId, String login);

	public UserProfile updateUserSecurity(String userId, UserSecurity security);

	public UserProfile saveUserProfile(UserProfile userProfile);

	public void approveIdentification(String id);

	public void declineIdentification(String id);

	public void resetIdentification(String id);

	public void verifyUserProfileEmail(String userId);

	public UserProfile updateUserGeneralSetting(String userId, UserGeneralSetting generalSetting);

}
