package com.zfinance.orm.userdefinedtypes;

import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@UserDefinedType("user_info_type")
public class UserInfo {

	private UserNameInfo namePlain;
	private UserNameInfo nameIntl;
	private String description;
	private String phoneNumber;
	private String email;
	private String dateOfBirth;
}
