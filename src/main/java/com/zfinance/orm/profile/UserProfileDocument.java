package com.zfinance.orm.profile;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.zfinance.orm.userdefinedtypes.profile.UserProfileFileType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document("zfin_user_profile_document")
public class UserProfileDocument {

	@Id
	@Field("id")
	private String id;

	@Field("file")
	private UserProfileFileType file;

	@Field("document_identifier")
	private String documentIdentifier;

	@Field("type")
	private String type;

	@Field("label")
	private String label;

	@Field("status")
	private String status;

	@Field("updated_at")
	private String updatedAt;
}
