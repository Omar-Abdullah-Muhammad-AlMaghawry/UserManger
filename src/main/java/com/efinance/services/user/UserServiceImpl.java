package com.efinance.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efinance.dto.request.PaginationRequestOptions;
import com.efinance.dto.request.user.UserCreateBody;
import com.efinance.dto.request.user.UsersFilter;
import com.efinance.dto.request.user.UsersSort;
import com.efinance.dto.response.PaginationResponse;
import com.efinance.dto.response.user.UserRecord;
import com.efinance.repositories.user.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public PaginationResponse<UserRecord> searchUsers(
			PaginationRequestOptions<UsersFilter, UsersSort> paginationRequestOptions) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(UserCreateBody userCreateBody) {
		try {
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void delete(String id) {
		try {
			// TODO Auto-generated method stub
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void unban(String userId) {
		try {
			// TODO Auto-generated method stub
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void toggleActivate(String userId, Boolean active) {
		try {
			// TODO Auto-generated method stub
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
