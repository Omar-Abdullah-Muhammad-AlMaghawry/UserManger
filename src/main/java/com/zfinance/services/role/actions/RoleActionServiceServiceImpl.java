package com.zfinance.services.role.actions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.zfinance.dto.request.role.actions.RoleActionFilter;
import com.zfinance.orm.role.actions.RoleAction;
import com.zfinance.repositories.role.actions.RoleActionRepository;
import com.zfinance.services.database.sequence.SequenceGeneratorService;

@Service
public class RoleActionServiceServiceImpl implements RoleActionService {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@Autowired
	private RoleActionRepository roleActionRepository;

	@Override
	public List<RoleAction> searchRoleActions(RoleActionFilter filter) {
		Query query = new Query();

		if (filter.getUserId() != null) {
			query.addCriteria(Criteria.where("userId").is(filter.getUserId()));
		}
		if (filter.getName() != null) {
			query.addCriteria(Criteria.where("name").is(filter.getName()));
		}
		if (filter.getRead() != null) {
			query.addCriteria(Criteria.where("read").is(filter.getRead()));
		}
		if (filter.getWrite() != null) {
			query.addCriteria(Criteria.where("write").is(filter.getWrite()));
		}

		return mongoTemplate.find(query, RoleAction.class);
	}

	@Override
	public List<RoleAction> getRecords() {
		return roleActionRepository.findAll();
	}

	@Override
	public RoleAction getRecordById(String id) {
		return roleActionRepository.findById(id).get();
	}

	@Override
	public RoleAction saveRoleAction(RoleAction roleAction) {
		if (roleAction != null && roleAction.getId() == null)
			roleAction.setId(sequenceGeneratorService.generateSequence(RoleAction.SEQUENCE_NAME));

		return roleActionRepository.save(roleAction);
	}

	@Override
	public List<RoleAction> getRecordByName(String name) {
		return roleActionRepository.findByName(name);
	}

	@Override
	public List<RoleAction> getRecordByUserId(String userId) {
		return roleActionRepository.findByUserId(userId);
	}

}
