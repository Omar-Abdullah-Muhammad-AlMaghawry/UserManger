package com.zfinance.dto.security;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MenuDto {

	private Long id;
	private String name;
	private Integer classification;
	private String url;
	private Integer order;
	private Integer activeFlag;
	private Long parentId;
	private Boolean hasChildren;

}
