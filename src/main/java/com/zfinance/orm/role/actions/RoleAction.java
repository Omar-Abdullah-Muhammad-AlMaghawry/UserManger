package com.zfinance.orm.role.actions;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document("zfin_role_action")
public class RoleAction {

	@Id
	@Field("id")
	private String id;

	@Field("user_id")
	private String userId;

	@Field("name")
	private String name;

	@Field("read")
	private Boolean read;

	@Field("write")
	private Boolean write;

	@Transient
	public static final String SEQUENCE_NAME = "role_action_sequence";

}
