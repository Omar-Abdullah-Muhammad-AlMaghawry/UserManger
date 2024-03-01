package com.zfinance.orm.role;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("zfin_Role")
public class Role {
	@Id
	@Field("id")
	private String id;

	@Field("code")
	private String code;

	@Field("name")
	private String name;

	@Field("description")
	private String description;

	@Transient
	public static final String SEQUENCE_NAME = "Role_sequence";
}