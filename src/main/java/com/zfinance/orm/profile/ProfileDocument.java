package com.zfinance.orm.profile;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.zfinance.orm.userdefinedtypes.profile.FileType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document("zfin_profile_document")
public class ProfileDocument {

	@Id
	@Field("id")
	private String id;

	@Field("file")
	private FileType file;

	@Field("label")
	private String label;

	@Field("type")
	private String type;

	@Field("status")
	private String status;

	@Field("document_identifier")
	private String documentIdentifier;

}
