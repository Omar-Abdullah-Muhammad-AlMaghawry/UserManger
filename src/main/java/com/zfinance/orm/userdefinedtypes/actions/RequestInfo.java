package com.zfinance.orm.userdefinedtypes.actions;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@UserDefinedType("request_info_type")
public class RequestInfo {

	@Column("host")
	private String host;

	@Column("user_agent")
	private String userAgent;

	@Column("user_ip")
	private String userIp;
}
