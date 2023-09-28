package com.zfinance.dto.response.actions;

import com.zfinance.orm.userdefinedtypes.actions.RequestInfo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ActionsOfUsersRecord {

	private String actionId;
	private String userId;
	private String comment;
	private String performedAt;
	private RequestInfo requestInfo;

}
