package com.zfinance.services.actions;

import java.util.List;

import com.zfinance.dto.request.actions.ActionsOfUsersFilter;
import com.zfinance.dto.request.actions.ActionsOfUsersSort;
import com.zfinance.orm.actionsOfUsers.Actions;
import com.zfinance.orm.actionsOfUsers.ActionsOfUsers;

public interface ActionsService {

	public List<ActionsOfUsers> getRecords(ActionsOfUsersFilter actionsOfUsersFilter,
			ActionsOfUsersSort actionsOfUsersSort);

	public List<Actions> getRecord(String actionId);

	public ActionsOfUsers saveActionOfUser(ActionsOfUsers actionsOfUsers);

	public Actions saveActions(Actions actions);

}
