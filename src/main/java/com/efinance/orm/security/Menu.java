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
@Table(name = "ZFIN_MENU")
public class Menu {

	@Id
	@Column(name = "ID")
	private Long id;

	@Basic
	@Column(name = "MENU_ORDER")
	private Long order;

	@Basic
	@Column(name = "NAME")
	private String name;

	@Basic
	@Column(name = "URL")
	private String url;

	@Basic
	@Column(name = "CLASSIFICATION")
	private int classification;

	@Basic
	@Column(name = "ACTIVE_FLAG")
	private Boolean activeFlag;

	@Basic
	@Column(name = "PARENT_ID")
	private Long parentId;

	@Basic
	@Column(name = "HAS_CHILDEREN")
	private Boolean hasChildren;

}
