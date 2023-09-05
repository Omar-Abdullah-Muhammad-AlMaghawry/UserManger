package com.zfinance.orm.userdefinedtypes.user;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@UserDefinedType("administrator_type")
public class Administrator {

	@Column("firstName")
	private String firstName;

	@Column("lastName")
	private String lastName;

	@Column("email")
	private String email;

	@Column("phone")
	private String phone;

}
