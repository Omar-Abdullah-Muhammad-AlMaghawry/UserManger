package com.zfinance.dto.response.profile;

import com.zfinance.orm.userdefinedtypes.profile.File;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProfileDocumentDto {

	private File file;
	private String id;
	private String label;
	private String type;
	private String status;
	private String documentIdentifier;

}
