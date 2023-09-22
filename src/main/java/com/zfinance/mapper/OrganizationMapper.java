package com.zfinance.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import com.zfinance.dto.response.organization.OrganizationRecord;
import com.zfinance.orm.organization.Organization;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrganizationMapper {

	OrganizationMapper INSTANCE = Mappers.getMapper(OrganizationMapper.class);

	public OrganizationRecord mapOrganization(Organization organization);

	public Organization mapOrganizationRecord(OrganizationRecord organizationRecord);

	public default Page<OrganizationRecord> mapOrganizations(Page<Organization> organizations) {
		return organizations.map(this::mapOrganization);
	}

	public List<OrganizationRecord> mapOrganizations(List<Organization> organizations);

}
