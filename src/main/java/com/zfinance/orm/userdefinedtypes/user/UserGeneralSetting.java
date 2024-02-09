package com.zfinance.orm.userdefinedtypes.user;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserGeneralSetting {

	@Field("notification_account")
	private NotificationAccount notificationAccount;

	@Field("marketing")
	private Marketing marketing;

}
