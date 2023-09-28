package com.zfinance.orm.userdefinedtypes.user;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Administrator {

	@Field("firstName")
	private String firstName;

	@Field("lastName")
	private String lastName;

	@Field("email")
	private String email;

	@Field("phone")
	private String phone;

}
