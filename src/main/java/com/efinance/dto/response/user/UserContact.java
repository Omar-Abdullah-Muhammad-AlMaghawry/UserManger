package com.efinance.dto.response.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserContact {

	private String phoneNumber;
	private boolean phoneVerified;
	private String email;
	private boolean emailVerified;
	private String countryCode;
}
