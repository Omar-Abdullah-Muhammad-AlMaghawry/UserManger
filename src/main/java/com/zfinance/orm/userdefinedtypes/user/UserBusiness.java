package com.zfinance.orm.userdefinedtypes.user;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserBusiness {

	@Field("company_name")
	private String companyName;

	@Field("type")
	private String type;

	@Field("vat")
	private String vat;

	@Field("administrator")
	private Administrator administrator;

}
