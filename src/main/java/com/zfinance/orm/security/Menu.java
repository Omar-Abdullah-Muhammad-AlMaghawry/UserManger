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
@Table("ZFIN_MENU")
public class Menu {

	@PrimaryKey
	@Column("ID")
	private Long id;

	@Column("MENU_ORDER")
	private Long order;

	@Column("NAME")
	private String name;

	@Column("URL")
	private String url;

	@Column("CLASSIFICATION")
	private int classification;

	@Column("ACTIVE_FLAG")
	private Boolean activeFlag;

	@Column("PARENT_ID")
	private Long parentId;

	@Column("HAS_CHILDEREN")
	private Boolean hasChildren;

}
