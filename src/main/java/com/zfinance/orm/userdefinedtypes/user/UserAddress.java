package com.zfinance.orm.userdefinedtypes.user;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserAddress {

	@Field("country")
	private String country;

	@Field("zip_code")
	private String zipCode;

	@Field("city")
	private String city;

	@Field("street")
	private String street;

	@Field("house_number")
	private String houseNumber;

}
