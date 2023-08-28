package com.zfinance.orm.security;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table("zfin_users_menus_actions")
public class UserMenuActionData {

	@PrimaryKey
	@Column("id")
	private Long id;

	@Column("menu_id")
	private Long menuId;

	@Column("user_id")
	private Long userId;

	@Column("menu_code")
	private String menuCode;

	@Column("module_id")
	private Long moduleId;

	@Column("action")
	private String action;

}
