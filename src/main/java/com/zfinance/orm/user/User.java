package com.zfinance.orm.user;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.zfinance.orm.userdefinedtypes.user.UserContact;
import com.zfinance.orm.userdefinedtypes.user.UserMemberRecord;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document("zfin_user")
public class User {

	@Id
	@Field("id")
	private String id;

	@Field("name")
	private String name;

	@Field("email")
	private String email;

	@Field("enc_password")
	private String encPassword;

	@Field("created_at")
	private String createdAt;

	@Field("active")
	private Boolean active;

	@Field("banned")
	private Boolean banned;

	@Field("ban_expiry_date")
	private String banExpiryDate;

//	@Field("role")
//	private String role;
//
//	@Field("organization_id")
//	private String organizationId;
//
//	@Field("legal_type")
//	private String legalType;

	@Field("contact")
	private UserContact contact;

	@Field("members")
	private List<UserMemberRecord> members;

	@Transient
	public static final String SEQUENCE_NAME = "user_sequence";

}
