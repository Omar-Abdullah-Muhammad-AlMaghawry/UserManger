package com.zfinance.orm.userdefinedtypes.profile;

import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@UserDefinedType("user_profile_file_type")
public class UserProfileFile {

	private String id;
	private String ownerId;
	private String mediaType;
	private String name;
	private String url;
	private String md5;
	private String sha1;
	private Long size;
	private Boolean used;
	private String createdAt;
	private String expiresAt;
	private String tag;

}
