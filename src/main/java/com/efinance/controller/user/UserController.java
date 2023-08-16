package com.efinance.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.efinance.dto.request.PaginationRequestOptions;
import com.efinance.dto.request.UsersFilter;
import com.efinance.dto.request.UsersSort;
import com.efinance.dto.response.PaginationResponse;
import com.efinance.dto.response.UsersRecord;
import com.efinance.services.user.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/view")
	public PaginationResponse<UsersRecord> searchUsers(
			PaginationRequestOptions<UsersFilter, UsersSort> paginationRequestOptions) {
		return userService.searchUsers(paginationRequestOptions);
	}

}
