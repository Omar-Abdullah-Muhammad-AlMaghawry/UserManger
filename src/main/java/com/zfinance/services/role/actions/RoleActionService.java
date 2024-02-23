package com.zfinance.services.role.actions;

import java.util.List;

import com.zfinance.dto.request.role.actions.RoleActionFilter;
import com.zfinance.orm.role.actions.RoleAction;

public interface RoleActionService {

	public List<RoleAction> searchRoleActions(RoleActionFilter filter);

	public List<RoleAction> getRecords();

	public RoleAction getRecordById(String id);

	public List<RoleAction> getRecordByName(String name);

	public List<RoleAction> getRecordByUserId(String userId);

	public RoleAction saveRoleAction(RoleAction roleAction);

}
