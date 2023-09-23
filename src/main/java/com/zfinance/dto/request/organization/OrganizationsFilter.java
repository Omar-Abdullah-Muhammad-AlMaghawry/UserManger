package com.zfinance.dto.request.organization;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class OrganizationsFilter {

	private String type;
	private String emitentId;
	private List<OrganizationTypes> organizationTypes;

}
