package com.zfinance.dto.response.invitation.link;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InvitationLinkResponse {

	List<InvitationLinkRecord> records;
}
