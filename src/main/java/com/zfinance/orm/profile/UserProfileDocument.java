package com.zfinance.orm.profile;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.zfinance.orm.userdefinedtypes.profile.UserProfileFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table("zfin_user_profile_document")
public class UserProfileDocument {

	@PrimaryKey
	@Column("id")
	private String id;

	@Column("file")
	private UserProfileFile file;

	@Column("document_identifier")
	private String documentIdentifier;

	@Column("type")
	private String type;

	@Column("label")
	private String label;

	@Column("status")
	private String status;

	@Column("updated_at")
	private String updatedAt;
}
