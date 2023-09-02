package com.zfinance.orm.userdefinedtypes;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@UserDefinedType("user_business_type")
public class UserBusiness {

	@Column("company_name")
	private String companyName;

	@Column("type")
	private String type;

	@Column("vat")
	private String vat;

	@Column("administrator")
	private Administrator administrator;

}
