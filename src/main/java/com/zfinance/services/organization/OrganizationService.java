package com.zfinance.services.organization;

import java.util.List;

import com.zfinance.dto.request.organization.OrganizationsFilter;
import com.zfinance.dto.request.organization.OrganizationsSort;
import com.zfinance.orm.organization.Organization;

public interface OrganizationService {
	public List<Organization> findAllOrganization();

	public List<Organization> findAllOrganizationByFilterAndSort(OrganizationsFilter organizationsFilter,
			OrganizationsSort organizationsSort);

}
