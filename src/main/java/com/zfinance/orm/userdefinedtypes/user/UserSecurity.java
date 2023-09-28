package com.zfinance.orm.userdefinedtypes.user;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserSecurity {

	@Field("two_factors_auth_enabled")
	private Boolean twoFactorsAuthEnabled;

	@Field("transaction_notification")
	private Notification transactionNotification;

	@Field("authorization_notification")
	private Notification authorizationNotification;

}
