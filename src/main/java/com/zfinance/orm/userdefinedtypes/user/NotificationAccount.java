package com.zfinance.orm.userdefinedtypes.user;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class NotificationAccount {

	@Field("account_adminstration")
	private Boolean accountAdminstration;

	@Field("transactions_and_balance")
	private Boolean transactionsAndBalance;

}
