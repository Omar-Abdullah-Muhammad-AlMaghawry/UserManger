package com.zfinance.services.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zfinance.orm.profile.UserProfile;
import com.zfinance.orm.userdefinedtypes.UserAddress;
import com.zfinance.orm.userdefinedtypes.UserBusiness;
import com.zfinance.orm.userdefinedtypes.UserInfo;
import com.zfinance.orm.userdefinedtypes.UserSecurity;
import com.zfinance.repositories.user.profile.UserProfileRepository;

@Service
public class UserProfileServiceImpl implements UserProfileService {

	@Autowired
	private UserProfileRepository userProfileRepository;

	@Override
	public UserProfile getUserProfile(String userId) {
		return userProfileRepository.findByUserId(userId);
	}

	@Override
	public void updateUserProfileInfo(String userId, UserInfo person) {
		UserProfile userProfile = userProfileRepository.findByUserId(userId);
		userProfile.setPerson(person);
		userProfileRepository.save(userProfile);
	}

	@Override
	public void updateUserAddress(String userId, UserAddress address) {
		UserProfile userProfile = userProfileRepository.findByUserId(userId);
		userProfile.setAddress(address);
		userProfileRepository.save(userProfile);
	}

	@Override
	public void updateUserBusiness(String userId, UserBusiness data) {
		UserProfile userProfile = userProfileRepository.findByUserId(userId);
		userProfile.setBusiness(data);
		userProfileRepository.save(userProfile);
	}

	@Override
	public void updateUserLogin(String userId, String login) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUserSecurity(String userId, UserSecurity security) {
		UserProfile userProfile = userProfileRepository.findByUserId(userId);
		userProfile.setSecurity(security);
		userProfileRepository.save(userProfile);
	}

	@Override
	public UserProfile saveUserProfile(UserProfile userProfile) {
		return userProfileRepository.save(userProfile);
	}

}
