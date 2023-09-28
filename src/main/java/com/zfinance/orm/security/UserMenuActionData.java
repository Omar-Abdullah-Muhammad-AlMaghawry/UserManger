package com.zfinance.orm.security;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document("zfin_users_menus_actions")
public class UserMenuActionData {

	@Id
	@Field("id")
	private Long id;

	@Field("menu_id")
	private Long menuId;

	@Field("user_id")
	private Long userId;

	@Field("menu_code")
	private String menuCode;

	@Field("module_id")
	private Long moduleId;

	@Field("action")
	private String action;

}
