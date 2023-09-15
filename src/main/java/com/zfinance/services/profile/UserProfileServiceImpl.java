package com.zfinance.services.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zfinance.enums.FileStatusEnum;
import com.zfinance.orm.profile.UserProfile;
import com.zfinance.orm.userdefinedtypes.user.UserAddress;
import com.zfinance.orm.userdefinedtypes.user.UserBusiness;
import com.zfinance.orm.userdefinedtypes.user.UserInfo;
import com.zfinance.orm.userdefinedtypes.user.UserSecurity;
import com.zfinance.repositories.profile.UserProfileRepository;

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

	// TODO: to be checked
	@Override
	public void approveIdentification(String id) {
		UserProfile userProfile = userProfileRepository.findByUserId(id);
		userProfile.setStatus(FileStatusEnum.APPROVED.getCode());
		userProfileRepository.save(userProfile);
	}

	@Override
	public void declineIdentification(String id) {
		UserProfile userProfile = userProfileRepository.findByUserId(id);
		userProfile.setStatus(FileStatusEnum.DECLINED.getCode());
		userProfileRepository.save(userProfile);
	}

	@Override
	public void resetIdentification(String id) {

		UserProfile userProfile = userProfileRepository.findByUserId(id);
		/// TODO: The user will need to upload the documents again to pass KYC
		/// verification.
		userProfileRepository.save(userProfile);

	}

}
