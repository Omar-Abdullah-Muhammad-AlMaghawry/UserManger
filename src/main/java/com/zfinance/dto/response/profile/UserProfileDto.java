package com.zfinance.dto.response.profile;

import com.zfinance.orm.userdefinedtypes.UserAddress;
import com.zfinance.orm.userdefinedtypes.UserBusiness;
import com.zfinance.orm.userdefinedtypes.UserContact;
import com.zfinance.orm.userdefinedtypes.UserInfo;
import com.zfinance.orm.userdefinedtypes.UserSecurity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserProfileDto {

	private String id;
	private String userId;
	private UserInfo person;
	private UserContact contact;
	private String type;
	private String status;
	private UserBusiness business;
	private UserAddress address;
	private UserSecurity security;

}
