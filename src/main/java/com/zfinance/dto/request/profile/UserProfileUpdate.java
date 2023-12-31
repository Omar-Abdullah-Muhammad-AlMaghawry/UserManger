package com.zfinance.dto.request.profile;

import com.zfinance.orm.userdefinedtypes.user.UserAddress;
import com.zfinance.orm.userdefinedtypes.user.UserIdentiy;
import com.zfinance.orm.userdefinedtypes.user.UserInfo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserProfileUpdate {
	private UserInfo person;
	private UserAddress address;
	private UserIdentiy identiy;

}
