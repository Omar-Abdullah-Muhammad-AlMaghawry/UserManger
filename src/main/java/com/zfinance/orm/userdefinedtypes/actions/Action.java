package com.zfinance.orm.userdefinedtypes.actions;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@UserDefinedType("action_type")
public class Action {

	@Column("role")
	private String role;

	@Column("action_type")
	private String actionType;

	@Column("entity_id")
	private String entityId;

	@Column("entity_name")
	private String entityName;

	@Column("type")
	private String type;
}
