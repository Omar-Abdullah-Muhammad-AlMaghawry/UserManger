package com.zfinance.dto.response.profile;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserProfileDocumentsResponse {

	private List<UserProfileDocumentDto> records;

}
