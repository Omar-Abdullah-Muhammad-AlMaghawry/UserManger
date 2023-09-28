package com.zfinance.dto.request.actions;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ActionsOfUsersFilter {

	private List<String> actionIds;
	private List<String> userIds;
	private List<String> userIps;
	private List<String> hosts;
	private String performedAtFrom;
	private String performedAtTo;

}
