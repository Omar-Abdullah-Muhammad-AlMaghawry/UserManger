package com.zfinance.dto.response.invitation.link;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InvitationLinkRecord {
	private String id;
	private String payeeId;
	private String link;
	private Boolean active;
}
