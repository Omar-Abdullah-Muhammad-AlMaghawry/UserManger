package com.zfinance.dto.response.role.action;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleActionResponse {
	private List<RoleActionRecord> actions;
}
