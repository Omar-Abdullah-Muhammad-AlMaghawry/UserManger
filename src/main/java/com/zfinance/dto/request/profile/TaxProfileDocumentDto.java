package com.zfinance.dto.request.profile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class TaxProfileDocumentDto {

	String documentIdentifier;
	String type;
}
