package com.zfinance.dto.response.profile;

import com.zfinance.orm.userdefinedtypes.user.UserAddress;
import com.zfinance.orm.userdefinedtypes.user.UserBusiness;
import com.zfinance.orm.userdefinedtypes.user.UserContact;
import com.zfinance.orm.userdefinedtypes.user.UserGeneralSetting;
import com.zfinance.orm.userdefinedtypes.user.UserIdentity;
import com.zfinance.orm.userdefinedtypes.user.UserInfo;
import com.zfinance.orm.userdefinedtypes.user.UserSecurity;

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
	private UserIdentity identity;
	private UserSecurity security;
	private UserGeneralSetting generalSetting;

}
