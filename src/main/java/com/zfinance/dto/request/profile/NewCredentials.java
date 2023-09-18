package com.zfinance.dto.request.profile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class NewCredentials {
	private String currentUserPassword;
	private String newUserPassword;
	private String confirmPassword;
}
