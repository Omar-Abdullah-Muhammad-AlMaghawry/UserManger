package com.zfinance.orm.organization;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.zfinance.orm.userdefinedtypes.user.UserContractInfo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document("zfin_organization")
public class Organization {

	@Id
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

	@Field("contract_info")
	private UserContractInfo contractInfo;

	@Field("created_at")
	private Date createdAt;

	@Transient
	public static final String SEQUENCE_NAME = "organization_sequence";

}
