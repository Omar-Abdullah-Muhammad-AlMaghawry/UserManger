package com.zfinance.orm.userdefinedtypes.profile;

import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@UserDefinedType("file_type")
public class File {

	private String id;
	private String name;
	private String ownerId;
	private Long size;
	private String url;

}
