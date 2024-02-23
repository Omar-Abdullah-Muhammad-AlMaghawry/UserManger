package com.zfinance.controller.role.actions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zfinance.dto.request.PaginationRequestOptions;
import com.zfinance.dto.request.role.actions.RoleActionFilter;
import com.zfinance.dto.response.role.action.RoleActionRecord;
import com.zfinance.dto.response.role.action.RoleActionResponse;
import com.zfinance.mapper.RoleActionMapper;
import com.zfinance.orm.role.actions.RoleAction;
import com.zfinance.services.role.actions.RoleActionService;

@RestController
@RequestMapping("/role-actions")
@CrossOrigin("*")
public class RoleActionController {

	@Autowired
	private RoleActionService roleActionService;

	@PostMapping("/searchRoleActions")
	public RoleActionResponse searchRoleActions(
			@RequestBody PaginationRequestOptions<RoleActionFilter, ?> paginationRequestOptions) {
		List<RoleActionRecord> roleActions = RoleActionMapper.INSTANCE.mapRoleActions(roleActionService
				.searchRoleActions(paginationRequestOptions.getFilter()));
		return new RoleActionResponse(roleActions);

	}

	@GetMapping
	public RoleActionResponse getRecords() {
		List<RoleActionRecord> roleActions = RoleActionMapper.INSTANCE.mapRoleActions(roleActionService.getRecords());
		return new RoleActionResponse(roleActions);
	}

	@GetMapping("/getRoleActionByName/{actionName}")
	public RoleActionResponse getRecordByName(@PathVariable String actionName) {
		List<RoleActionRecord> roleActions = RoleActionMapper.INSTANCE.mapRoleActions(roleActionService.getRecordByName(
				actionName));
		return new RoleActionResponse(roleActions);
	}

	@GetMapping("/getRoleActionByUserId/{userId}")
	public RoleActionResponse getRecordByUserId(@PathVariable String userId) {
		List<RoleActionRecord> roleActions = RoleActionMapper.INSTANCE.mapRoleActions(roleActionService
				.getRecordByUserId(userId));
		return new RoleActionResponse(roleActions);
	}

	@PostMapping("/save")
	public RoleActionRecord saveRoleAction(@RequestBody RoleActionRecord roleActionRecord) {
		RoleAction roleAction = roleActionService.saveRoleAction(RoleActionMapper.INSTANCE.mapRoleActionRecord(
				roleActionRecord));
		return RoleActionMapper.INSTANCE.mapRoleAction(roleAction);
	}
}
