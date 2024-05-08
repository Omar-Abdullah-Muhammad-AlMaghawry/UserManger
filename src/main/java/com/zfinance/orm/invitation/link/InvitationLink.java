package com.zfinance.orm.invitation.link;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("zfin_invitation_link")
public class InvitationLink {

	@Id
	@Field("id")
	private String id;

	@Field("payee_id")
	private String payeeId;

	@Field("link")
	private String link;

	@Field("active")
	private Boolean active;

	@Transient
	public static final String SEQUENCE_NAME = "invitation_link_sequence";

}
