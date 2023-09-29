package com.zfinance.dto.request.profile;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserProfileDocumentsFilter {

	private List<String> userIds;
	private List<String> statuses;

}
