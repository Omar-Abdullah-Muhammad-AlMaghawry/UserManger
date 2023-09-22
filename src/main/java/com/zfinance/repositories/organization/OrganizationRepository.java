package com.zfinance.repositories.organization;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zfinance.dto.request.organization.OrganizationTypes;
import com.zfinance.orm.organization.Organization;

public interface OrganizationRepository extends CassandraRepository<Organization, String> {

	@Query("SELECT * FROM zfin_organization " + "WHERE organization_type IN (:p_types) " + "ORDER BY ( created_at ) "
			+ "ALLOW FILTERING")
	List<Organization> findAllByFilterAndSort(@Param("p_types") List<String> types,
			@Param("p_emitent_id") String emitentId,
			@Param("p_organization_types") List<OrganizationTypes> organizationTypes,
			@Param("p_created_at") String createdAt);

}
