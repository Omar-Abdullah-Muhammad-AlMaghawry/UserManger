package com.zfinance.orm.userdefinedtypes;

import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@UserDefinedType("notification_type")
public class Notification {

	private Boolean phone;
	private Boolean email;

}
