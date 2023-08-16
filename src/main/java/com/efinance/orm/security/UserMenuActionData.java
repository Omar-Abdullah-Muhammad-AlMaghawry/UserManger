package com.efinance.orm.security;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ZFIN_VW_USERS_MENUS_ACTIONS")
public class UserMenuActionData {

	@Id
	@Column(name = "ID")
	private Long userMenuActionId;

	@Basic
	@Column(name = "MENU_ID")
	private Long menuId;

	@Basic
	@Column(name = "USER_ID")
	private Long userId;

	@Basic
	@Column(name = "MENU_CODE")
	private String menuCode;

	@Basic
	@Column(name = "MODULE_ID")
	private Long moduleId;

	@Basic
	@Column(name = "ACTION")
	private String action;

}
