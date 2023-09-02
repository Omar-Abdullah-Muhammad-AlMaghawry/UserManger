package com.zfinance.orm.userdefinedtypes;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@UserDefinedType("user_info_type")
public class UserInfo {

	@Column("name_plain")
	private UserNameInfo namePlain;

	@Column("name_intl")
	private UserNameInfo nameIntl;

	@Column("description")
	private String description;

	@Column("phone_number")
	private String phoneNumber;

	@Column("email")
	private String email;

	@Column("date_of_birth")
	private String dateOfBirth;
}
