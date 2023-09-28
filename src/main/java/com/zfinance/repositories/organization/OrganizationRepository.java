package com.zfinance.repositories.organization;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.zfinance.dto.request.organization.OrganizationsFilter;
import com.zfinance.dto.request.organization.OrganizationsSort;
import com.zfinance.orm.organization.Organization;

public interface OrganizationRepository extends MongoRepository<Organization, String> {

	@Query("{ $and: [" + "?#{ [0]?.type != null ? { 'type': [0]?.type } : null },"
			+ "?#{ [0]?.emitentId != null ? { 'emitentId': [0]?.emitentId } : null },"
			+ "?#{ [0]?.organizationTypes != null ? { 'organizationTypes': { $in: [0]?.organizationTypes } } : null }"
			+ "] }" + ", $orderby: { " + "?#{ [1]?.createdAt != null ? 'createdAt' : null } : 1" + "}")
	List<Organization> searchOrganizations(OrganizationsFilter filter, OrganizationsSort sort);

}
