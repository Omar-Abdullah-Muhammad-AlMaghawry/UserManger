package com.zfinance.dto.request.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserCreateBody {
	private String login;
	private String role;
	private String organizationId;
	private String legalType;

	private String password;
}
