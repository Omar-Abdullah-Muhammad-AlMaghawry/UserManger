package com.zfinance.orm.actions;

import java.util.List;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.zfinance.orm.userdefinedtypes.actions.Action;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table("zfin_actions")
public class Actions {

	@PrimaryKey("id")
	private String actionId;

	@Column("objects_of_action")
	private List<Action> objectsOfAction;

}
