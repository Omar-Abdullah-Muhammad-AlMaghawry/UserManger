package com.zfinance.orm.userdefinedtypes.actions;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Action {

	@Field("role")
	private String role;

	@Field("action_type")
	private String actionType;

	@Field("entity_id")
	private String entityId;

	@Field("entity_name")
	private String entityName;

	@Field("type")
	private String type;
}
