package com.zfinance.dto.response.role.action;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoleActionRecord {

	private String id;
	private String userId;
	private String name;
	private Boolean read;
	private Boolean write;
}
