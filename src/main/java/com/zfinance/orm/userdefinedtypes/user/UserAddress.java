package com.zfinance.orm.userdefinedtypes.user;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@UserDefinedType("user_address_type")
public class UserAddress {

	@Column("country")
	private String country;

	@Column("zip_code")
	private String zipCode;

	@Column("city")
	private String city;

	@Column("street")
	private String street;

	@Column("house_number")
	private String houseNumber;

}
