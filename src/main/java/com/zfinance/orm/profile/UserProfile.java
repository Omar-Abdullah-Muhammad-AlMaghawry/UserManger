package com.zfinance.orm.profile;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.zfinance.orm.userdefinedtypes.user.UserAddress;
import com.zfinance.orm.userdefinedtypes.user.UserBusiness;
import com.zfinance.orm.userdefinedtypes.user.UserContact;
import com.zfinance.orm.userdefinedtypes.user.UserInfo;
import com.zfinance.orm.userdefinedtypes.user.UserSecurity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document("zfin_user_profile")
public class UserProfile {

	@Id
	@Field("id")
	private String id;

	@Field("user_id")
	private String userId;

	@Field("person")
	private UserInfo person;

	@Field("contact")
	private UserContact contact;

	@Field("type")
	private String type;

	@Field("status")
	private String status;

	@Field("business")
	private UserBusiness business;

	@Field("address")
	private UserAddress address;

	@Field("security")
	private UserSecurity security;

}
