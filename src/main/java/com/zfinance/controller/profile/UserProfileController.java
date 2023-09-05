package com.zfinance.controller.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zfinance.dto.response.SuccessResponse;
import com.zfinance.dto.response.profile.GetUserInfoResponse;
import com.zfinance.mapper.UserProfileMapper;
import com.zfinance.orm.profile.UserProfile;
import com.zfinance.orm.userdefinedtypes.user.UserAddress;
import com.zfinance.orm.userdefinedtypes.user.UserBusiness;
import com.zfinance.orm.userdefinedtypes.user.UserInfo;
import com.zfinance.orm.userdefinedtypes.user.UserSecurity;
import com.zfinance.services.profile.UserProfileService;

@RestController
@RequestMapping("/profiles")
@CrossOrigin("*")
public class UserProfileController {

	@Autowired
	private UserProfileService userProfileService;

	@GetMapping("/{userId}")
	public GetUserInfoResponse getUserProfile(@PathVariable String userId) {
		UserProfile userProfile = userProfileService.getUserProfile(userId);
		GetUserInfoResponse getUserInfoResponse = new GetUserInfoResponse();
		getUserInfoResponse.setProfile(UserProfileMapper.INSTANCE.mapUserProfile(userProfile));
		return getUserInfoResponse;
	}

	@PatchMapping("/{userId}/person")
	public SuccessResponse<Void> updateUserProfileInfo(@PathVariable String userId, @RequestBody UserInfo person) {
		userProfileService.updateUserProfileInfo(userId, person);
		SuccessResponse<Void> successResponse = new SuccessResponse<>();
		return successResponse;
	}

	@PatchMapping("/{userId}/address")
	public SuccessResponse<Void> updateUserAddress(@PathVariable String userId, @RequestBody UserAddress address) {
		userProfileService.updateUserAddress(userId, address);
		SuccessResponse<Void> successResponse = new SuccessResponse<>();
		return successResponse;
	}

	@PatchMapping("/{userId}/business")
	public SuccessResponse<Void> updateUserBusiness(@PathVariable String userId, @RequestBody UserBusiness data) {
		userProfileService.updateUserBusiness(userId, data);
		SuccessResponse<Void> successResponse = new SuccessResponse<>();
		return successResponse;
	}

	@PatchMapping("/{userId}/contact")
	public SuccessResponse<Void> updateUserLogin(@PathVariable String userId, @RequestBody String login) {
		userProfileService.updateUserLogin(userId, login);
		SuccessResponse<Void> successResponse = new SuccessResponse<>();
		return successResponse;
	}

	@PatchMapping("/{userId}/security-settings")
	public SuccessResponse<Void> updateUserSecurity(@PathVariable String userId, @RequestBody UserSecurity security) {
		userProfileService.updateUserSecurity(userId, security);
		SuccessResponse<Void> successResponse = new SuccessResponse<>();
		return successResponse;
	}

}
