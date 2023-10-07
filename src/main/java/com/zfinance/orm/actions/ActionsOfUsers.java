package com.zfinance.orm.actions;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.zfinance.orm.userdefinedtypes.actions.RequestInfo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document("zfin_actions_of_users")
public class ActionsOfUsers {

	@Id
	@Field("id")
	private String actionId;

	@Field("user_id")
	private String userId;

	@Field("comment")
	private String comment;

	@Field("performed_at")
	private String performedAt;

	@Field("request_info")
	private RequestInfo requestInfo;

	@Transient
	public static final String SEQUENCE_NAME = "actions_of_users_sequence";

}
