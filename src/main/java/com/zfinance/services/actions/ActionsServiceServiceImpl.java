package com.zfinance.services.actions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.zfinance.dto.request.PaginationRequestOptions;
import com.zfinance.dto.request.actions.ActionsOfUsersFilter;
import com.zfinance.dto.request.actions.ActionsOfUsersSort;
import com.zfinance.orm.actionsOfUsers.Actions;
import com.zfinance.orm.actionsOfUsers.ActionsOfUsers;
import com.zfinance.repositories.actions.ActionsOfUsersRepository;
import com.zfinance.repositories.actions.ActionsRepository;

@Service
public class ActionsServiceServiceImpl implements ActionsService {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private ActionsOfUsersRepository actionsOfUsersRepository;

	@Autowired
	private ActionsRepository actionsRepository;

	@Override
	public List<ActionsOfUsers> getRecords(PaginationRequestOptions<ActionsOfUsersFilter, ActionsOfUsersSort> options) {

		ActionsOfUsersFilter actionsOfUsersFilter = options.getFilter();
		ActionsOfUsersSort actionsOfUsersSort = options.getSort();

		Criteria criteria = new Criteria();

		// Add actionsOfUsersFilter criteria based on the actionsOfUsersFilter object
		if (actionsOfUsersFilter != null) {
			if (actionsOfUsersFilter.getActionIds() != null && !actionsOfUsersFilter.getActionIds().isEmpty()) {
				criteria.and("actionId").in(actionsOfUsersFilter.getActionIds());
			}
			if (actionsOfUsersFilter.getUserIds() != null && !actionsOfUsersFilter.getUserIds().isEmpty()) {
				criteria.and("userId").in(actionsOfUsersFilter.getUserIds());
			}
			if (actionsOfUsersFilter.getUserIps() != null && !actionsOfUsersFilter.getUserIps().isEmpty()) {
				criteria.and("requestInfo.ipAddress").in(actionsOfUsersFilter.getUserIps());
			}
			if (actionsOfUsersFilter.getHosts() != null && !actionsOfUsersFilter.getHosts().isEmpty()) {
				criteria.and("requestInfo.host").in(actionsOfUsersFilter.getHosts());
			}
			if (actionsOfUsersFilter.getPerformedAtFrom() != null) {
				criteria.and("performedAt").gte(actionsOfUsersFilter.getPerformedAtFrom());
			}
			if (actionsOfUsersFilter.getPerformedAtTo() != null) {
				criteria.and("performedAt").lte(actionsOfUsersFilter.getPerformedAtTo());
			}
			// Add other actionsOfUsersFilter criteria as needed...
		}

		Query query = new Query(criteria);

		// Apply sorting
		if (actionsOfUsersSort != null && actionsOfUsersSort.getDateCreated() != null) {

			if (actionsOfUsersSort.getDateCreated().equalsIgnoreCase("asc")) {
				query.with(Sort.by(Sort.Order.asc("performedAt")));
			} else if (actionsOfUsersSort.getDateCreated().equalsIgnoreCase("desc")) {
				query.with(Sort.by(Sort.Order.desc("performedAt")));
			}
		}
		int page = (null != options.getPageNumber()) ? Integer.valueOf(options.getPageNumber()) : 0;
		int size = (null != options.getPageSize()) ? Integer.valueOf(options.getPageSize()) : 0;
		if (page != 0 && size != 0) {
			Pageable pageable = Pageable.ofSize(size).withPage(page);
			return mongoTemplate.find(query.with(pageable), ActionsOfUsers.class);
		}
		return mongoTemplate.find(query, ActionsOfUsers.class);
	}

	@Override
	public List<Actions> getRecord(String actionId) {
		return actionsRepository.findByActionId(actionId);
	}

	@Override
	public ActionsOfUsers saveActionOfUser(ActionsOfUsers actionsOfUsers) {
		return actionsOfUsersRepository.save(actionsOfUsers);

	}

	@Override
	public Actions saveActions(Actions actions) {
		return actionsRepository.save(actions);
	}

}
