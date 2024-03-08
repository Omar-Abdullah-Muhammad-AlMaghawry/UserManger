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

	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String dateOfBirth;

	private String merchantId;
	private String id;

}
