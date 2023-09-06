package com.zfinance.dto.response.profile;

import com.zfinance.orm.userdefinedtypes.profile.FileType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProfileDocumentDto {

	private FileType file;
	private String id;
	private String label;
	private String type;
	private String status;
	private String documentIdentifier;

}
