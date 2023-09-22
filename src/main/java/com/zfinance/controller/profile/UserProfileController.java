package com.zfinance.controller.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zfinance.config.filters.TokenAuthorizationFilter;
import com.zfinance.dto.request.profile.MyPersonDto;
import com.zfinance.dto.request.profile.NewCredentials;
import com.zfinance.dto.response.SuccessResponse;
import com.zfinance.dto.response.profile.GetUserInfoResponse;
import com.zfinance.dto.response.profile.MyUserProfileResponse;
import com.zfinance.dto.response.user.UserRecord;
import com.zfinance.mapper.UserProfileMapper;
import com.zfinance.orm.profile.UserProfile;
import com.zfinance.orm.userdefinedtypes.user.UserAddress;
import com.zfinance.orm.userdefinedtypes.user.UserBusiness;
import com.zfinance.orm.userdefinedtypes.user.UserInfo;
import com.zfinance.orm.userdefinedtypes.user.UserSecurity;
import com.zfinance.services.external.AuthManagerService;
import com.zfinance.services.profile.UserProfileService;
import com.zfinance.services.user.UserService;

@RestController
@RequestMapping("/profiles")
@CrossOrigin("*")
public class UserProfileController {

	@Autowired
	private UserProfileService userProfileService;

	@Autowired
	private UserService userService;

	@Autowired
	private AuthManagerService authManagerService;

	@Autowired
	private TokenAuthorizationFilter tokenAuthorizationFilter;

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

	@PostMapping("/{id}/approve")
	public SuccessResponse<Void> approveIdentification(@PathVariable String id) {
		userProfileService.approveIdentification(id);
		SuccessResponse<Void> successResponse = new SuccessResponse<>();
		return successResponse;
	}

	@PostMapping("/{id}/decline")
	public SuccessResponse<Void> declineIdentification(@PathVariable String id) {
		userProfileService.declineIdentification(id);
		SuccessResponse<Void> successResponse = new SuccessResponse<>();
		return successResponse;
	}

	@GetMapping("/my")
	public MyUserProfileResponse getUserProfile() {
		String token = tokenAuthorizationFilter.getToken();
		UserRecord user = authManagerService.getUserIdFromToken(token);
		UserProfile userProfile = userProfileService.getUserProfile(user.getId());
		MyUserProfileResponse myUserProfileResponse = new MyUserProfileResponse();
		myUserProfileResponse.setProfile(UserProfileMapper.INSTANCE.mapUserProfile(userProfile));

		return myUserProfileResponse;
	}

	@PatchMapping("/my/password")
	public SuccessResponse<Void> declineIdentification(@RequestBody NewCredentials newCredentials) {
		String token = tokenAuthorizationFilter.getToken();
		UserRecord user = authManagerService.getUserIdFromToken(token);
		userService.updatePassword(user.getId(), newCredentials);
		SuccessResponse<Void> successResponse = new SuccessResponse<>();
		return successResponse;
	}

	@PatchMapping("/my/person")
	public MyUserProfileResponse updatePersonInformation(@RequestBody MyPersonDto options) {
		String token = tokenAuthorizationFilter.getToken();
		UserRecord user = authManagerService.getUserIdFromToken(token);
		UserProfile userProfile = userProfileService.updateUserProfileInfo(user.getId(), options.getPerson());
		MyUserProfileResponse myUserProfileResponse = new MyUserProfileResponse();
		myUserProfileResponse.setProfile(UserProfileMapper.INSTANCE.mapUserProfile(userProfile));
		return myUserProfileResponse;
	}

	@PatchMapping("/my/contact")
	public MyUserProfileResponse updateMyLogin(@RequestBody String login) {
		String token = tokenAuthorizationFilter.getToken();
		UserRecord user = authManagerService.getUserIdFromToken(token);
		UserProfile userProfile = userProfileService.updateUserLogin(user.getId(), login);
		MyUserProfileResponse myUserProfileResponse = new MyUserProfileResponse();
		myUserProfileResponse.setProfile(UserProfileMapper.INSTANCE.mapUserProfile(userProfile));
		return myUserProfileResponse;
	}

	@PatchMapping("/my/security-settings")
	public MyUserProfileResponse updateMySecurity(@RequestBody UserSecurity security) {
		String token = tokenAuthorizationFilter.getToken();
		UserRecord user = authManagerService.getUserIdFromToken(token);
		UserProfile userProfile = userProfileService.updateUserSecurity(user.getId(), security);
		MyUserProfileResponse myUserProfileResponse = new MyUserProfileResponse();
		myUserProfileResponse.setProfile(UserProfileMapper.INSTANCE.mapUserProfile(userProfile));
		return myUserProfileResponse;
	}

}
