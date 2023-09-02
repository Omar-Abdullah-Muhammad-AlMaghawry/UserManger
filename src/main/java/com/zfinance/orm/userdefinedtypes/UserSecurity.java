package com.zfinance.orm.userdefinedtypes;

import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@UserDefinedType("user_security_type")
public class UserSecurity {

	private Boolean twoFactorsAuthEnabled;
	private Notification transactionNotification;
	private Notification authorizationNotification;

}
