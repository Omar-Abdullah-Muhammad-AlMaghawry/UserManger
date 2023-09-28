package com.zfinance.orm.userdefinedtypes.user;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserInfo {

	@Field("name_plain")
	private UserNameInfo namePlain;

	@Field("name_intl")
	private UserNameInfo nameIntl;

	@Field("description")
	private String description;

	@Field("phone_number")
	private String phoneNumber;

	@Field("email")
	private String email;

	@Field("date_of_birth")
	private String dateOfBirth;
}
