package com.efinance.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.efinance.dto.request.PaginationRequestOptions;
import com.efinance.dto.request.user.UserCreateBody;
import com.efinance.dto.request.user.UsersFilter;
import com.efinance.dto.request.user.UsersSort;
import com.efinance.dto.response.PaginationResponse;
import com.efinance.dto.response.user.UsersRecord;
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

	@PostMapping
	public void save(@RequestBody UserCreateBody userCreateBody) {
		userService.save(userCreateBody);
	}

	@DeleteMapping("{userId}")
	public void delete(@PathVariable String userId) {
		userService.delete(userId);
	}

	@PostMapping("{userId}/unban")
	public void unban(@PathVariable String userId) {
		userService.unban(userId);
	}

	@PatchMapping("{userId}")
	public void toggleActivate(@PathVariable String userId, @RequestBody Boolean active) {
		userService.toggleActivate(userId, active);
		;
	}

}
