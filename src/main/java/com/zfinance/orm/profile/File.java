package com.zfinance.orm.profile;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Document("zfin_file")
public class File {

	@Id
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

	@Transient
	public static final String SEQUENCE_NAME = "file_sequence";

}
