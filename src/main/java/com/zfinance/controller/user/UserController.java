package com.zfinance.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zfinance.dto.request.PaginationRequestOptions;
import com.zfinance.dto.request.user.UserCreateBody;
import com.zfinance.dto.request.user.UsersFilter;
import com.zfinance.dto.request.user.UsersSort;
import com.zfinance.dto.response.PaginationResponse;
import com.zfinance.dto.response.SuccessResponse;
import com.zfinance.dto.response.user.UserRecord;
import com.zfinance.mapper.UserMapper;
import com.zfinance.orm.user.User;
import com.zfinance.services.user.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/view")
	public PaginationResponse<UserRecord> searchUsers(
			@RequestBody PaginationRequestOptions<UsersFilter, UsersSort> paginationRequestOptions) {
		PaginationResponse<UserRecord> paginationResponse = new PaginationResponse<UserRecord>();
		List<User> users = userService.searchUsers(paginationRequestOptions.getFilter(), paginationRequestOptions
				.getSort());
		paginationResponse.setRecords(UserMapper.INSTANCE.mapUsers(users));
		paginationResponse.setTotalRecords(users.size());
		return paginationResponse;
	}

	@PostMapping("/viewAllUsers")
	public PaginationResponse<UserRecord> viewAllUsers() {
		PaginationResponse<UserRecord> paginationResponse = new PaginationResponse<UserRecord>();
		List<User> users = userService.findAllUser();
		paginationResponse.setRecords(UserMapper.INSTANCE.mapUsers(users));
		paginationResponse.setTotalRecords(users.size());
		return paginationResponse;
	}

	@PostMapping
	public SuccessResponse<Void> save(@RequestBody UserCreateBody userCreateBody) {
		userService.create(userCreateBody);
		SuccessResponse<Void> successResponse = new SuccessResponse<>();
		return successResponse;
	}

	@DeleteMapping("{userId}")
	public SuccessResponse<Void> delete(@PathVariable String userId) {
		userService.delete(userId);
		SuccessResponse<Void> successResponse = new SuccessResponse<>();
		return successResponse;
	}

	@PostMapping("{userId}/unban")
	public SuccessResponse<Void> unban(@PathVariable String userId) {
		userService.unban(userId);
		SuccessResponse<Void> successResponse = new SuccessResponse<>();
		return successResponse;
	}

	@PatchMapping("{userId}")
	public SuccessResponse<Void> toggleActivate(@PathVariable String userId, @RequestBody Boolean active) {
		userService.toggleActivate(userId, active);
		SuccessResponse<Void> successResponse = new SuccessResponse<>();
		return successResponse;
	}

}
