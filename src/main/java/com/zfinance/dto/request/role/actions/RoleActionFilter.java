package com.zfinance.dto.request.role.actions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class RoleActionFilter {
	private String userId;
	private String name;
	private Boolean read;
	private Boolean write;
}
