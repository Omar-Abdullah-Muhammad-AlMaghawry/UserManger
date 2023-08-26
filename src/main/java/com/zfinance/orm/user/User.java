package com.zfinance.orm.user;

import java.util.List;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.zfinance.dto.response.user.UserContact;
import com.zfinance.dto.response.user.UserMemberRecord;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table("ZFIN_USER")
public class User {

	@PrimaryKey
	@Column("ID")
	private String id;

	@Column("NAME")
	private String name;

	@Column("CREATED_AT")
	private String createdAt;

	@Column("ACTIVE")
	private boolean active;

	@Column("BANNED")
	private boolean banned;

	@Column("BAN_EXPIRY_DATE")
	private String banExpiryDate;

	@Column("CONTACT")
	private UserContact contact;

	@Column("MEMBERS")
	private List<UserMemberRecord> members;

}
