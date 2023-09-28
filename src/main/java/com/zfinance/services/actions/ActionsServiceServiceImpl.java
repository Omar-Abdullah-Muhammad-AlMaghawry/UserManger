package com.zfinance.services.actions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zfinance.dto.request.actions.ActionsOfUsersFilter;
import com.zfinance.dto.request.actions.ActionsOfUsersSort;
import com.zfinance.orm.actions.Actions;
import com.zfinance.orm.actions.ActionsOfUsers;
import com.zfinance.repositories.actions.ActionsOfUsersRepository;
import com.zfinance.repositories.actions.ActionsRepository;

@Service
public class ActionsServiceServiceImpl implements ActionsService {

	@Autowired
	private ActionsOfUsersRepository actionsOfUsersRepository;

	@Autowired
	private ActionsRepository actionsRepository;

	@Override
	public List<ActionsOfUsers> getRecords(ActionsOfUsersFilter actionsOfUsersFilter,
			ActionsOfUsersSort actionsOfUsersSort) {
		return actionsOfUsersRepository.findAllByFilter();
	}

	@Override
	public List<Actions> getRecord(String actionId) {
		return actionsRepository.findAllById(actionId);
	}

}
