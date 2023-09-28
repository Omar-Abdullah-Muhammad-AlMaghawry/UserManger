package com.zfinance.orm.actions;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.zfinance.orm.userdefinedtypes.actions.Action;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document("zfin_actions")
public class Actions {

	@Id
	@Field("id")
	private String actionId;

	@Field("objects_of_action")
	private List<Action> objectsOfAction;

}
