package com.zfinance.dto.response.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserContract {
	private String id;
//	private String contractName;
	private Long userCount;
}
