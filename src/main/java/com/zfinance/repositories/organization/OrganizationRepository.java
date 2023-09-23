package com.zfinance.repositories.organization;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zfinance.dto.request.organization.OrganizationTypes;
import com.zfinance.orm.organization.Organization;

public interface OrganizationRepository extends CassandraRepository<Organization, String> {

	@Query("SELECT * FROM zfin_organization " + "WHERE organization_type = :p_type " + "ALLOW FILTERING")
	List<Organization> findAllByFilter(@Param("p_type") String types, @Param("p_emitent_id") String emitentId,
			@Param("p_organization_types") List<OrganizationTypes> organizationTypes);

}
