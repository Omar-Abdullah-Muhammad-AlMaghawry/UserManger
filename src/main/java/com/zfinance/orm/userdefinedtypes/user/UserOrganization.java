package com.zfinance.orm.userdefinedtypes.user;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@UserDefinedType("user_organization_type")
public class UserOrganization {

	@Column("id")
	private String id;

	@Column("name")
	private String name;

	@Column("status")
	private String status;

	@Column("message")
	private String message;

	@Column("organization_type")
	private String type;

	@Column("identification_status")
	private String identificationStatus;

	@Column("organization_status")
	private String organizationStatus;

}
