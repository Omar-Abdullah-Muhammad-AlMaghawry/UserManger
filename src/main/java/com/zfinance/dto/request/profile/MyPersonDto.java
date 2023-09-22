package com.zfinance.dto.request.profile;

import com.zfinance.orm.userdefinedtypes.user.UserInfo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class MyPersonDto {
	private UserInfo person;
}
