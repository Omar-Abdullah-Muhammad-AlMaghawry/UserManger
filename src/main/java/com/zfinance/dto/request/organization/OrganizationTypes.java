package com.zfinance.dto.request.organization;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class OrganizationTypes {

	private List<String> additionalIssuableCoinTypes;
	private Boolean autoDeletable;
	private Boolean registrable;
	private String coinType;
	private List<String> issuableCoinTypes;
	private String bundleKey;
	private String business;
	private String code;

}
