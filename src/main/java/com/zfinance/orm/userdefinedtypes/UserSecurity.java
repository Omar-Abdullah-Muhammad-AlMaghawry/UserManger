package com.zfinance.orm.userdefinedtypes;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@UserDefinedType("user_security_type")
public class UserSecurity {

	@Column("two_factors_auth_enabled")
	private Boolean twoFactorsAuthEnabled;

	@Column("transaction_notification")
	private Notification transactionNotification;

	@Column("authorization_notification")
	private Notification authorizationNotification;

}
