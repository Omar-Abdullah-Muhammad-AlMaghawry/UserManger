package com.zfinance.orm.userdefinedtypes.user;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@UserDefinedType("user_name_info_type")
public class UserNameInfo {

	@Column("first")
	private String first;

	@Column("middle")
	private String middle;

	@Column("last")
	private String last;

}
