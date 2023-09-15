package com.zfinance.orm.profile;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.zfinance.orm.userdefinedtypes.user.UserAddress;
import com.zfinance.orm.userdefinedtypes.user.UserBusiness;
import com.zfinance.orm.userdefinedtypes.user.UserContact;
import com.zfinance.orm.userdefinedtypes.user.UserInfo;
import com.zfinance.orm.userdefinedtypes.user.UserSecurity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table("zfin_user_profile")
public class UserProfile {

	@PrimaryKey
	@Column("id")
	private String id;

	@Column("user_id")
	private String userId;

	@Column("person")
	private UserInfo person;

	@Column("contact")
	private UserContact contact;

	@Column("type")
	private String type;

	@Column("status")
	private String status;

	@Column("business")
	private UserBusiness business;

	@Column("address")
	private UserAddress address;

	@Column("security")
	private UserSecurity security;

}