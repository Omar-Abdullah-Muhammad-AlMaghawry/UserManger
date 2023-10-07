package com.zfinance.orm.security;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document("zfin_menu")
public class Menu {

	@Id
	@Field("id")
	private Long id;

	@Field("menu_order")
	private Long order;

	@Field("name")
	private String name;

	@Field("url")
	private String url;

	@Field("classification")
	private int classification;

	@Field("active_flag")
	private Boolean activeFlag;

	@Field("parent_id")
	private Long parentId;

	@Field("has_children")
	private Boolean hasChildren;

	@Transient
	public static final String SEQUENCE_NAME = "menu_sequence";

}
