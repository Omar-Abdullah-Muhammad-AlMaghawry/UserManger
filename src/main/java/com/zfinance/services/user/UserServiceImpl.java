package com.zfinance.services.user;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zfinance.dto.request.user.UserCreateBody;
import com.zfinance.dto.request.user.UsersFilter;
import com.zfinance.dto.request.user.UsersSort;
import com.zfinance.exceptions.DataNotFoundException;
import com.zfinance.orm.user.User;
import com.zfinance.orm.userdefinedtypes.UserContact;
import com.zfinance.repositories.user.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> searchUsers(UsersFilter usersFilter, UsersSort usersSort) {

		return userRepository.findUsersByFilter(usersFilter.getBanned());
//				userRepository.findUsersByFilter(usersFilter.getIds(), usersFilter.getEmail(),
//				usersFilter.getEmailVerified(), usersFilter.getPhone(), usersFilter.getPhoneVerified(),
//				usersFilter.getText(), usersFilter.getBanned(), usersFilter.getActive(), usersFilter.getRoles(),
//				usersFilter.getOrganizationIds(), usersSort.getCreatedAt(), usersSort.getActive());

	}

	@Override
	public void create(UserCreateBody userCreateBody) {
		User user = new User();
		UserContact userContact = new UserContact();
		String emailOrPhoneNember = userCreateBody.getLogin();

		if (emailOrPhoneNember.contains("@")) {
			userContact.setEmail(emailOrPhoneNember);
		} else {
			userContact.setPhoneNumber(emailOrPhoneNember);
		}
		user.setContact(userContact);
		user.setCreatedAt((new Date()).toString());
		user.setActive(true);
		user.setBanned(false);
		user.setRole(userCreateBody.getRole());
		user.setOrganizationId(userCreateBody.getOrganizationId());
		user.setLegalType(userCreateBody.getLegalType());
		userRepository.save(user);
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
