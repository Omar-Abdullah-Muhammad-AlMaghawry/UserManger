package com.zfinance.orm.userdefinedtypes.profile;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserProfileFileType {

	@Field("id")
	private String id;

	@Field("owner_id")
	private String ownerId;

	@Field("media_type")
	private String mediaType;

	@Field("name")
	private String name;

	@Field("url")
	private String url;

	@Field("md5")
	private String md5;

	@Field("sha1")
	private String sha1;

	@Field("size")
	private Long size;

	@Field("used")
	private Boolean used;

	@Field("created_at")
	private String createdAt;

	@Field("expires_at")
	private String expiresAt;

	@Field("tag")
	private String tag;

}
