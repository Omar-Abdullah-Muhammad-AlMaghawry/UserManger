package com.zfinance.dto.response.profile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyUserProfileResponse {
	private UserProfileDto profile;
	private Object memberShips;
}
