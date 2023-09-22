package com.zfinance.controller.organization;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zfinance.dto.request.PaginationRequestOptions;
import com.zfinance.dto.request.organization.OrganizationsFilter;
import com.zfinance.dto.request.organization.OrganizationsSort;
import com.zfinance.dto.response.PaginationResponse;
import com.zfinance.dto.response.organization.OrganizationRecord;
import com.zfinance.mapper.OrganizationMapper;
import com.zfinance.services.organization.OrganizationService;

@RestController
@RequestMapping("/organizations")
@CrossOrigin("*")
public class OrganizationController {

	@Autowired
	private OrganizationService organizationService;

	@PostMapping
	public PaginationResponse<OrganizationRecord> getOrganizations(
			@RequestBody PaginationRequestOptions<OrganizationsFilter, OrganizationsSort> data) {
		List<OrganizationRecord> organizationRecords = OrganizationMapper.INSTANCE.mapOrganizations(organizationService
				.findAllOrganizationByFilterAndSort(data.getFilter(), data.getSort()));
		PaginationResponse<OrganizationRecord> paginationResponse = new PaginationResponse<>();
		paginationResponse.setRecords(organizationRecords);
		paginationResponse.setTotalRecords(organizationRecords.size());

		// TODO: to be edit
		paginationResponse.setPageSize(data.getPageSize() != null ? Integer.valueOf(data.getPageSize()) : null);
		paginationResponse.setPageNumber(data.getPageNumber() != null ? Integer.valueOf(data.getPageNumber()) : null);
		return paginationResponse;
	}

}
