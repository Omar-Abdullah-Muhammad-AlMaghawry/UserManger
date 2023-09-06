package com.zfinance.dto.response.profile;

import com.zfinance.orm.userdefinedtypes.profile.UserProfileFileType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserProfileDocumentDto {

	private String id;
	private UserProfileFileType file;
	private String documentIdentifier;
	private String type;
	private String label;
	private String status;
	private String updatedAt;

}
