package com.zfinance.dto.response.actions;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ActionsResponse {
	private List<ActionsRecord> records;
}
