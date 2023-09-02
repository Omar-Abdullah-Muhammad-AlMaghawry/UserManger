package com.zfinance.orm.userdefinedtypes;

import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@UserDefinedType("user_address_type")
public class UserAddress {
	
	private String country;
    private String zipCode;
    private String city;
    private String street;
    private String houseNumber;
	
}
