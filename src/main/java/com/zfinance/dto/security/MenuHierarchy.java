package com.zfinance.dto.security;

import java.util.List;

import com.zfinance.orm.security.Menu;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MenuHierarchy {

	private Menu parent;
	private List<Menu> children;

}
