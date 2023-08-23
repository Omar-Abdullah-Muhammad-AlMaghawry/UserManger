package com.efinance.services.user;

import com.efinance.dto.request.PaginationRequestOptions;
import com.efinance.dto.request.user.UserCreateBody;
import com.efinance.dto.request.user.UsersFilter;
import com.efinance.dto.request.user.UsersSort;
import com.efinance.dto.response.PaginationResponse;
import com.efinance.dto.response.user.UserRecord;

public interface UserService {

	public PaginationResponse<UserRecord> searchUsers(
			PaginationRequestOptions<UsersFilter, UsersSort> paginationRequestOptions);

	public void save(UserCreateBody userCreateBody);

	public void delete(String userId);

	public void unban(String userId);

	public void toggleActivate(String userId, Boolean active);

}
