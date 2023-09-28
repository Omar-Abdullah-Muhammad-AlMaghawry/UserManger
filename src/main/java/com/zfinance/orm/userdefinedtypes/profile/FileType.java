package com.zfinance.orm.userdefinedtypes.profile;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class FileType {

	@Field("id")
	private String id;

	@Field("name")
	private String name;

	@Field("owner_id")
	private String ownerId;

	@Field("size")
	private Long size;

	@Field("url")
	private String url;

}
