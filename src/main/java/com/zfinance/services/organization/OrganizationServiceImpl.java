package com.zfinance.services.organization;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zfinance.dto.request.organization.OrganizationsFilter;
import com.zfinance.dto.request.organization.OrganizationsSort;
import com.zfinance.orm.organization.Organization;
import com.zfinance.repositories.organization.OrganizationRepository;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private OrganizationRepository organizationRepository;

	@Override
	public List<Organization> findAllOrganization() {
		return organizationRepository.findAll();
	}

	@Override
	public List<Organization> findAllOrganizationByFilterAndSort(OrganizationsFilter organizationsFilter,
			OrganizationsSort organizationsSort) {
		if (organizationsFilter != null)
			return organizationRepository.findAllByFilterAndSort(organizationsFilter.getTypes(), organizationsFilter
					.getEmitentId(), organizationsFilter.getOrganizationTypes(), organizationsSort.getCreatedAt());
		else
			return this.findAllOrganization();
	}

}
