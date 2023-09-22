package com.zfinance.dto.response.organization;

import com.zfinance.orm.userdefinedtypes.user.UserContractInfo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class OrganizationRecord {

	private String id;
	private String name;
	private String status;
	private String message;
	private String type;
	private String identificationStatus;
	private UserContractInfo contractInfo;

}
