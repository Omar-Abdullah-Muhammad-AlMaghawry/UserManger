package com.zfinance.orm.userdefinedtypes.actions;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class RequestInfo {

	@Field("host")
	private String host;

	@Field("user_agent")
	private String userAgent;

	@Field("user_ip")
	private String userIp;
}
