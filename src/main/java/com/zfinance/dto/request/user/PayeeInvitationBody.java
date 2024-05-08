package com.zfinance.dto.request.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PayeeInvitationBody {
	private String merchantId;
	private String numberOfPayees;
	private String refName;
}
