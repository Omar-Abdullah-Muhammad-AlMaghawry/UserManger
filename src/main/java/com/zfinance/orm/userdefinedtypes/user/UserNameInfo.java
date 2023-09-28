package com.zfinance.orm.userdefinedtypes.user;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserNameInfo {

	@Field("first")
	private String first;

	@Field("middle")
	private String middle;

	@Field("last")
	private String last;

}
