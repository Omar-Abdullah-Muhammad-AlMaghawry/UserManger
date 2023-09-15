package com.zfinance.services.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.zfinance.dto.request.user.UserCreateBody;
import com.zfinance.dto.request.user.UsersFilter;
import com.zfinance.dto.request.user.UsersSort;
import com.zfinance.exceptions.DataNotFoundException;
import com.zfinance.orm.profile.UserProfile;
import com.zfinance.orm.user.User;
import com.zfinance.orm.userdefinedtypes.user.UserContact;
import com.zfinance.orm.userdefinedtypes.user.UserContractInfo;
import com.zfinance.orm.userdefinedtypes.user.UserMemberRecord;
import com.zfinance.orm.userdefinedtypes.user.UserOrganization;
import com.zfinance.repositories.user.UserRepository;
import com.zfinance.services.external.AuthManagerService;
import com.zfinance.services.profile.UserProfileService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserProfileService userProfileService;

	@Autowired
	private AuthManagerService authManagerService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public List<User> searchUsers(UsersFilter usersFilter, UsersSort usersSort) {

//		return userRepository.findUsersByFilter(usersFilter.getBanned());
		return userRepository.findUsersByFilter(usersFilter.getIds(), usersFilter.getEmail(), usersFilter
				.getEmailVerified(), usersFilter.getPhone(), usersFilter.getPhoneVerified(), usersFilter.getText(),
				usersFilter.getBanned(), usersFilter.getActive(), usersFilter.getRoles(), usersSort.getCreatedAt(),
				usersSort.getActive());

	}

	@Override
	public List<User> findAllUser() {
		return userRepository.findAll();
	}

	@Override
	public void create(UserCreateBody userCreateBody) {
		User user = new User();
		UserContact userContact = new UserContact();
		UserMemberRecord memberRecord = new UserMemberRecord();
		UserOrganization userOrganization = new UserOrganization();
		UserContractInfo userContractInfo = new UserContractInfo();

		List<UserMemberRecord> memberRecords = new ArrayList<UserMemberRecord>();

		String emailOrPhoneNember = userCreateBody.getLogin();

		if (emailOrPhoneNember.contains("@")) {
			user.setEmail(emailOrPhoneNember);
			userContact.setEmail(emailOrPhoneNember);
		} else {
			userContact.setPhoneNumber(emailOrPhoneNember);
		}
		user.setId(UUID.randomUUID().toString());
		user.setContact(userContact);
		user.setCreatedAt((new Date()).toString());
		user.setActive(true);
		user.setBanned(false);
		memberRecord.setRole(userCreateBody.getRole());
		userOrganization.setId(userCreateBody.getOrganizationId());
		userContractInfo.setPersonType(userCreateBody.getLegalType());
		memberRecord.setContractInfo(userContractInfo);
		memberRecord.setOrganization(userOrganization);
//		user.setRole(userCreateBody.getRole());
//		user.setOrganizationId(userCreateBody.getOrganizationId());
//		user.setLegalType(userCreateBody.getLegalType());
		memberRecords.add(memberRecord);
		user.setMembers(memberRecords);

		String encPassword = passwordEncoder.encode(userCreateBody.getPassword());
		user.setEncPassword(encPassword);

		authManagerService.registerUser(user);
//		user = userRepository.save(user);

		UserProfile userProfile = new UserProfile();
		userProfile.setId(UUID.randomUUID().toString());
		userProfile.setUserId(user.getId());

		userProfileService.saveUserProfile(userProfile);

	}

	@Override
	public void delete(String id) {
		userRepository.deleteById(id);

	}

	@Override
	public void unban(String userId) {
		Optional<User> userOptional = userRepository.findById(userId);
		if (userOptional.isPresent()) {
			User user = userOptional.get();
			user.setBanned(false);
			userRepository.save(user);
		} else {
			throw new DataNotFoundException(User.class, userId);
		}
	}

	@Override
	public void toggleActivate(String userId, Boolean active) {
		Optional<User> userOptional = userRepository.findById(userId);

		if (userOptional.isPresent()) {
			User user = userOptional.get();
			user.setActive(active);
			userRepository.save(user);
		} else {
			throw new DataNotFoundException(User.class, userId);
		}
	}

}
