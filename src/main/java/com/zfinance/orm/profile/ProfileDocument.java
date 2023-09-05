package com.zfinance.orm.profile;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.zfinance.orm.userdefinedtypes.profile.File;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table("zfin_profile_document")
public class ProfileDocument {

	@PrimaryKey
	@Column("id")
	private String id;

	@Column("file")
	private File file;

	@Column("label")
	private String label;

	@Column("type")
	private String type;

	@Column("status")
	private String status;

	@Column("document_identifier")
	private String documentIdentifier;

}
