package com.zfinance.services.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zfinance.dto.request.user.UserCreateBody;
import com.zfinance.dto.request.user.UsersFilter;
import com.zfinance.dto.request.user.UsersSort;
import com.zfinance.exceptions.DataNotFoundException;
import com.zfinance.orm.user.User;
import com.zfinance.repositories.user.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> searchUsers(UsersFilter usersFilter, UsersSort usersSort) {

		return userRepository.findUsersByFilter(usersFilter.getIds(), usersFilter.getEmail(),
				usersFilter.getEmailVerified(), usersFilter.getPhone(), usersFilter.getPhoneVerified(),
				usersFilter.getText(), usersFilter.getBanned(), usersFilter.getActive(), usersFilter.getRoles(),
				usersFilter.getOrganizationIds(), usersSort.getCreatedAt(), usersSort.getActive());

	}

	@Override
	public void save(UserCreateBody userCreateBody) {
		// TODO:
	}

	@Override
	public void delete(String id) {
		userRepository.deleteById(id);

	}

	@Override
	public void unban(String userId) {
		// TODO:
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
