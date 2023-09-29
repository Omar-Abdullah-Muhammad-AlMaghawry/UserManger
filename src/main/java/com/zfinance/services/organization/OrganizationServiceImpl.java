package com.zfinance.services.organization;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.zfinance.dto.request.organization.OrganizationsFilter;
import com.zfinance.dto.request.organization.OrganizationsSort;
import com.zfinance.exceptions.DataNotFoundException;
import com.zfinance.orm.organization.Organization;
import com.zfinance.repositories.organization.OrganizationRepository;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private OrganizationRepository organizationRepository;

	@Override
	public List<Organization> findAllOrganization() {
		return organizationRepository.findAll();
	}

	@Override
	public Organization findOrganizationById(String id) {
		Optional<Organization> optional = organizationRepository.findById(id);
		if (optional.isPresent())
			return optional.get();
		else
			throw new DataNotFoundException(Organization.class, id);
	}

	@Override
	public List<Organization> findAllOrganizationByFilterAndSort(OrganizationsFilter organizationsFilter,
			OrganizationsSort organizationsSort) {
		Criteria criteria = new Criteria();

		// Add organizationsFilter criteria based on the organizationsFilter object
		if (organizationsFilter != null) {
			if (organizationsFilter.getType() != null) {
				criteria.and("type").is(organizationsFilter.getType());
			}
			if (organizationsFilter.getEmitentId() != null) {
				criteria.and("emitentId").is(organizationsFilter.getEmitentId());
			}
			if (organizationsFilter.getOrganizationTypes() != null && !organizationsFilter.getOrganizationTypes()
					.isEmpty()) {
				criteria.and("organizationTypes").in(organizationsFilter.getOrganizationTypes());
			}
			// Add other organizationsFilter criteria as needed...
		}

		Query query = new Query(criteria);

		// Apply sorting
		if (organizationsSort != null && organizationsSort.getCreatedAt() != null) {
			if (organizationsSort.getCreatedAt().equalsIgnoreCase("asc")) {
				query.with(Sort.by(Sort.Order.asc("createdAt")));
			} else if (organizationsSort.getCreatedAt().equalsIgnoreCase("desc")) {
				query.with(Sort.by(Sort.Order.desc("createdAt")));
			}
		}

		return mongoTemplate.find(query, Organization.class);
	}

	@Override
	public Organization save(Organization organization) {
		return organizationRepository.save(organization);
	}

}
