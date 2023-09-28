package com.zfinance.dto.response.actions;

import java.util.List;

import com.zfinance.orm.userdefinedtypes.actions.Action;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ActionsRecord {

	private String actionId;
	private List<Action> objectsOfAction;

}
