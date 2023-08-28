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
@Table("zfin_menu")
public class Menu {

	@PrimaryKey
	@Column("id")
	private Long id;

	@Column("menu_order")
	private Long order;

	@Column("name")
	private String name;

	@Column("url")
	private String url;

	@Column("classification")
	private int classification;

	@Column("active_flag")
	private Boolean activeFlag;

	@Column("parent_id")
	private Long parentId;

	@Column("has_children")
	private Boolean hasChildren;

}
