package com.zfinance.orm.userdefinedtypes.profile;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@UserDefinedType("file_type")
public class FileType {

	@Column("id")
	private String id;

	@Column("name")
	private String name;

	@Column("owner_id")
	private String ownerId;

	@Column("size")
	private Long size;

	@Column("url")
	private String url;

}
