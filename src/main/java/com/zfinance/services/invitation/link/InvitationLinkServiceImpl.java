package com.zfinance.services.invitation.link;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zfinance.exceptions.DataNotFoundException;
import com.zfinance.orm.invitation.link.InvitationLink;
import com.zfinance.repositories.invitation.link.InvitationLinkRepository;
import com.zfinance.services.database.sequence.SequenceGeneratorService;

@Service
public class InvitationLinkServiceImpl implements InvitationLinkService {

	@Autowired
	private InvitationLinkRepository invitationLinkRepository;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@Override
	public List<InvitationLink> getInvitationLinks() {
		return invitationLinkRepository.findAll();
	}

	@Override
	public InvitationLink getInvitationLinkById(String id) {
		Optional<InvitationLink> optionalInvitationLink = invitationLinkRepository.findById(id);
		if (optionalInvitationLink.isPresent())
			return optionalInvitationLink.get();
		else
			throw new DataNotFoundException(InvitationLink.class, id);
	}

	@Override
	public InvitationLink saveInvitationLink(InvitationLink invitationLink) {
		if (invitationLink != null && invitationLink.getId() == null)
			invitationLink.setId(sequenceGeneratorService.generateSequence(InvitationLink.SEQUENCE_NAME));
		return invitationLinkRepository.save(invitationLink);
	}

	@Override
	public void deleteInvitationLinkById(String id) {
		invitationLinkRepository.deleteById(id);
	}

}
