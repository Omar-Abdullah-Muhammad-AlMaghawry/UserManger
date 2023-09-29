package com.zfinance.services.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zfinance.enums.StatusEnum;
import com.zfinance.orm.profile.UserProfile;
import com.zfinance.orm.userdefinedtypes.user.UserAddress;
import com.zfinance.orm.userdefinedtypes.user.UserBusiness;
import com.zfinance.orm.userdefinedtypes.user.UserContact;
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
	public UserProfile updateUserProfileInfo(String userId, UserInfo person) {
		UserProfile userProfile = userProfileRepository.findByUserId(userId);
		userProfile.setPerson(person);
		return userProfileRepository.save(userProfile);
	}

	@Override
	public UserProfile updateUserAddress(String userId, UserAddress address) {
		UserProfile userProfile = userProfileRepository.findByUserId(userId);
		userProfile.setAddress(address);
		return userProfileRepository.save(userProfile);
	}

	@Override
	public UserProfile updateUserBusiness(String userId, UserBusiness data) {
		UserProfile userProfile = userProfileRepository.findByUserId(userId);
		userProfile.setBusiness(data);
		return userProfileRepository.save(userProfile);
	}

	@Override
	public UserProfile updateUserLogin(String userId, String login) {
		// TODO: need to be completed

//		User user = userService.getUserById(userId);
		UserProfile userProfile = userProfileRepository.findByUserId(userId);
		UserContact userContact = userProfile.getContact();

		if (userContact.getEmail() != null)
			userContact.setEmail(login);
		userProfile.setContact(userContact);
//		user.setContact(userContact);
		// TODO: need to verify the email, then save it

		return userProfileRepository.save(userProfile);
	}

	@Override
	public UserProfile updateUserSecurity(String userId, UserSecurity security) {
		UserProfile userProfile = userProfileRepository.findByUserId(userId);
		userProfile.setSecurity(security);
		return userProfileRepository.save(userProfile);
	}

	@Override
	public UserProfile saveUserProfile(UserProfile userProfile) {
		return userProfileRepository.save(userProfile);
	}

	// TODO: to be checked
	@Override
	public void approveIdentification(String id) {
		UserProfile userProfile = userProfileRepository.findByUserId(id);
		userProfile.setStatus(StatusEnum.APPROVED.getCode());
		userProfileRepository.save(userProfile);
	}

	@Override
	public void declineIdentification(String id) {
		UserProfile userProfile = userProfileRepository.findByUserId(id);
		userProfile.setStatus(StatusEnum.DECLINED.getCode());
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
