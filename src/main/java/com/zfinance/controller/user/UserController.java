package com.zfinance.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zfinance.dto.request.PaginationRequestOptions;
import com.zfinance.dto.request.user.ActiveDto;
import com.zfinance.dto.request.user.PayeeInvitationBody;
import com.zfinance.dto.request.user.UserCreateBody;
import com.zfinance.dto.request.user.UsersFilter;
import com.zfinance.dto.request.user.UsersSort;
import com.zfinance.dto.response.PaginationResponse;
import com.zfinance.dto.response.SuccessResponse;
import com.zfinance.dto.response.user.InvitationResponse;
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
		List<User> users = userService.searchUsers(paginationRequestOptions);
		paginationResponse.setRecords(UserMapper.INSTANCE.mapUsers(users));
		paginationResponse.setTotalRecords(users.size());
		int page = (null != paginationRequestOptions.getPageNumber()) ? Integer.valueOf(paginationRequestOptions
				.getPageNumber()) : 0;
		int size = (null != paginationRequestOptions.getPageSize()) ? Integer.valueOf(paginationRequestOptions
				.getPageSize()) : 0;
		paginationResponse.setPageSize(size);
		paginationResponse.setPageNumber(page);
		Integer totalPages = Integer.valueOf(users.size() / 5);
		paginationResponse.setTotalPages(totalPages);
		return paginationResponse;
	}

	@GetMapping("/viewAllUsers")
	public PaginationResponse<UserRecord> viewAllUsers() {
		PaginationResponse<UserRecord> paginationResponse = new PaginationResponse<UserRecord>();
		List<User> users = userService.findAllUser();
		paginationResponse.setRecords(UserMapper.INSTANCE.mapUsers(users));
		paginationResponse.setTotalRecords(users.size());
		return paginationResponse;
	}

	@PostMapping
	public UserRecord save(@RequestBody UserCreateBody userCreateBody) {
		userCreateBody.setPassword("12345");
		User user = userService.create(userCreateBody);
		return UserMapper.INSTANCE.mapUser(user);
	}

	@PostMapping("/registration")
	public UserRecord registerUser(@RequestBody UserCreateBody userCreateBody) {
		userCreateBody.setPassword("12345");
		User user = userService.create(userCreateBody);
		return UserMapper.INSTANCE.mapUser(user);
	}

	@DeleteMapping("/{userId}")
	public SuccessResponse<Void> delete(@PathVariable String userId) {
		userService.delete(userId);
		SuccessResponse<Void> successResponse = new SuccessResponse<>();
		return successResponse;
	}

	@PostMapping("/{userId}/unban")
	public SuccessResponse<Void> unban(@PathVariable String userId) {
		userService.unban(userId);
		SuccessResponse<Void> successResponse = new SuccessResponse<>();
		return successResponse;
	}

	@PatchMapping("/{userId}")
	public SuccessResponse<Void> toggleActivate(@PathVariable String userId, @RequestBody ActiveDto activeDto) {
		userService.toggleActivate(userId, activeDto.getActive());
		SuccessResponse<Void> successResponse = new SuccessResponse<>();
		return successResponse;
	}

	@PostMapping("/searchUsers")
	public List<UserRecord> searchUsers(@RequestBody UsersFilter usersFilter) {
		PaginationRequestOptions<UsersFilter, UsersSort> paginationRequestOptions = new PaginationRequestOptions<UsersFilter, UsersSort>();
		paginationRequestOptions.setFilter(usersFilter);
		List<User> users = userService.searchUsers(paginationRequestOptions);
		return UserMapper.INSTANCE.mapUsers(users);
	}

	@PostMapping("/saveUser")
	public UserRecord saveUser(@RequestBody UserRecord userRecord) {
		return UserMapper.INSTANCE.mapUser(userService.saveUser(UserMapper.INSTANCE.mapUserRecord(userRecord)));
	}

	@PostMapping("/invitePayee")
	public UserRecord invitePayee(@RequestBody String refName) {
		UserRecord userRecord = new UserRecord();
		userRecord.setRefName(refName);
		return UserMapper.INSTANCE.mapUser(userService.saveUser(UserMapper.INSTANCE.mapUserRecord(userRecord)));
	}

	@PostMapping("/invitePayees")
	public InvitationResponse invitePayees(@RequestBody PayeeInvitationBody payeeInvitationBody) {
		return new InvitationResponse(userService.invitePayees(payeeInvitationBody));
	}
}
