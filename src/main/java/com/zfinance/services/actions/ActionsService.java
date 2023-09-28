package com.zfinance.services.actions;

import java.util.List;

import com.zfinance.dto.request.actions.ActionsOfUsersFilter;
import com.zfinance.dto.request.actions.ActionsOfUsersSort;
import com.zfinance.orm.actions.Actions;
import com.zfinance.orm.actions.ActionsOfUsers;

public interface ActionsService {

	public List<ActionsOfUsers> getRecords(ActionsOfUsersFilter actionsOfUsersFilter,
			ActionsOfUsersSort actionsOfUsersSort);

	public List<Actions> getRecord(String actionId);

}
