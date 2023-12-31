package com.zfinance.orm.userdefinedtypes.user;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserIdentity {

	@Field("issuing_country")
	private String issuingCountry;

	@Field("type")
	private String type;

	@Field("number")
	private String number;

	@Field("date_of_expiry")
	private String dateOfExpiry;

}
