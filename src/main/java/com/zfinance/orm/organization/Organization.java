package com.zfinance.orm.organization;

import java.util.Date;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.zfinance.orm.userdefinedtypes.user.UserContractInfo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table("zfin_organization")
public class Organization {

	@PrimaryKey
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

	@Column("contract_info")
	private UserContractInfo contractInfo;

	@Column("created_at")
	private Date createdAt;
}
