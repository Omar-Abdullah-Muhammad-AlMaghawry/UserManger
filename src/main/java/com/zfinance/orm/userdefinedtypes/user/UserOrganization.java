package com.zfinance.orm.userdefinedtypes.user;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserOrganization {

	@Field("id")
	private String id;

	@Field("name")
	private String name;

	@Field("status")
	private String status;

	@Field("message")
	private String message;

	@Field("organization_type")
	private String type;

	@Field("identification_status")
	private String identificationStatus;

	@Field("organization_status")
	private String organizationStatus;

}
