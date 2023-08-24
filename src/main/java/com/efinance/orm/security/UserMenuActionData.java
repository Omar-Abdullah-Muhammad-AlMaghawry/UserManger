package com.efinance.orm.security;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table("ZFIN_VW_USERS_MENUS_ACTIONS")
public class UserMenuActionData {

	@Id
	@PrimaryKey
	@Column("ID")
	private Long userMenuActionId;

	@Column("MENU_ID")
	private Long menuId;

	@Column("USER_ID")
	private Long userId;

	@Column("MENU_CODE")
	private String menuCode;

	@Column("MODULE_ID")
	private Long moduleId;

	@Column("ACTION")
	private String action;

}
