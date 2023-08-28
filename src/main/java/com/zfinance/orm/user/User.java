package com.zfinance.orm.user;

import java.util.List;

import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.zfinance.orm.userdefinedtypes.UserContact;
import com.zfinance.orm.userdefinedtypes.UserMemberRecord;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table("zfin_user")
public class User {

	@PrimaryKey
	@Column("id")
	private String id;

	@Column("name")
	private String name;

	@Column("created_at")
	private String createdAt;

	@Column("active")
	private boolean active;

	@Column("banned")
	private boolean banned;

	@Column("ban_expiry_date")
	private String banExpiryDate;

	@Column("role")
	private String role;

	@Column("organization_id")
	private String organizationId;

	@Column("legal_type")
	private String legalType;

	@Column("contact")
	@CassandraType(type = CassandraType.Name.UDT, userTypeName = "user_contact_type")
	private UserContact contact;

	@Column("members")
	private List<UserMemberRecord> members;

}
