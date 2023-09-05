package com.zfinance.orm.userdefinedtypes.user;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@UserDefinedType("notification_type")
public class Notification {

	@Column("phone")
	private Boolean phone;

	@Column("email")
	private Boolean email;

}
