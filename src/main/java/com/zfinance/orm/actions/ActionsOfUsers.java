package com.zfinance.orm.actions;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.zfinance.orm.userdefinedtypes.actions.RequestInfo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table("zfin_actions_of_users")
public class ActionsOfUsers {

	@PrimaryKey("id")
	private String actionId;

	@Column("user_id")
	private String userId;

	@Column("comment")
	private String comment;

	@Column("performed_at")
	private String performedAt;

	@Column("request_info")
	private RequestInfo requestInfo;
}
