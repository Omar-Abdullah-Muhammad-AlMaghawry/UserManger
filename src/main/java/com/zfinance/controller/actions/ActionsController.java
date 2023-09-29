package com.zfinance.controller.actions;

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
import com.zfinance.dto.request.actions.ActionsOfUsersFilter;
import com.zfinance.dto.request.actions.ActionsOfUsersSort;
import com.zfinance.dto.response.PaginationResponse;
import com.zfinance.dto.response.actions.ActionsOfUsersRecord;
import com.zfinance.dto.response.actions.ActionsRecord;
import com.zfinance.dto.response.actions.ActionsResponse;
import com.zfinance.mapper.ActionsMapper;
import com.zfinance.mapper.ActionsOfUsersMapper;
import com.zfinance.orm.actions.Actions;
import com.zfinance.orm.actions.ActionsOfUsers;
import com.zfinance.services.actions.ActionsService;

@RestController
@RequestMapping("/users/view")
@CrossOrigin("*")
public class ActionsController {

	@Autowired
	private ActionsService actionsService;

	@PostMapping("/actions")
	public PaginationResponse<ActionsOfUsersRecord> getRecords(
			@RequestBody PaginationRequestOptions<ActionsOfUsersFilter, ActionsOfUsersSort> options) {
		List<ActionsOfUsers> actionsOfUsers = actionsService.getRecords(options.getFilter(), options.getSort());
		PaginationResponse<ActionsOfUsersRecord> paginationResponse = new PaginationResponse<>();
		paginationResponse.setRecords(ActionsOfUsersMapper.INSTANCE.mapActionsOfUserses(actionsOfUsers));
		return paginationResponse;
	}

	@GetMapping("/{actionId}/action-reverse")
	public ActionsResponse getRecord(@PathVariable String actionId) {
		List<Actions> actions = actionsService.getRecord(actionId);
		ActionsResponse actionsResponse = new ActionsResponse();
		actionsResponse.setRecords(ActionsMapper.INSTANCE.mapActions(actions));
		return actionsResponse;
	}

	@PostMapping("/actionOfUser/save")
	public ActionsOfUsersRecord saveActionOfUser(@RequestBody ActionsOfUsersRecord actionsOfUsersRecord) {
		ActionsOfUsers actionsOfUsers = actionsService.saveActionOfUser(ActionsOfUsersMapper.INSTANCE
				.mapActionsOfUsersRecord(actionsOfUsersRecord));
		return ActionsOfUsersMapper.INSTANCE.mapActionsOfUsers(actionsOfUsers);
	}

	@PostMapping("/actions/save")
	public ActionsRecord saveAction(@RequestBody ActionsRecord actionsRecord) {
		Actions actions = actionsService.saveActions(ActionsMapper.INSTANCE.mapActionsRecord(actionsRecord));
		return ActionsMapper.INSTANCE.mapActions(actions);
	}
}
