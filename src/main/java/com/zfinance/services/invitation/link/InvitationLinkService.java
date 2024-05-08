package com.zfinance.services.invitation.link;

import java.util.List;

import com.zfinance.orm.invitation.link.InvitationLink;

public interface InvitationLinkService {

	public List<InvitationLink> getInvitationLinks();

	public InvitationLink getInvitationLinkById(String id);

	public InvitationLink saveInvitationLink(InvitationLink invitationLink);

	public void deleteInvitationLinkById(String id);

}
