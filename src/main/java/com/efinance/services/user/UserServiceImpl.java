package com.efinance.services.user;

import com.efinance.dto.request.PaginationRequestOptions;
import com.efinance.dto.request.user.UserCreateBody;
import com.efinance.dto.request.user.UsersFilter;
import com.efinance.dto.request.user.UsersSort;
import com.efinance.dto.response.PaginationResponse;
import com.efinance.dto.response.user.UsersRecord;

public class UserServiceImpl implements UserService {

	@Override
	public PaginationResponse<UsersRecord> searchUsers(
			PaginationRequestOptions<UsersFilter, UsersSort> paginationRequestOptions) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(UserCreateBody userCreateBody) {
		try {
			// TODO Auto-generated method stub
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
