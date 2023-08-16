package com.efinance.services.user;

import com.efinance.dto.request.PaginationRequestOptions;
import com.efinance.dto.request.UsersFilter;
import com.efinance.dto.request.UsersSort;
import com.efinance.dto.response.PaginationResponse;
import com.efinance.dto.response.UsersRecord;

public interface UserService {

	public PaginationResponse<UsersRecord> searchUsers(
			PaginationRequestOptions<UsersFilter, UsersSort> paginationRequestOptions);
}
