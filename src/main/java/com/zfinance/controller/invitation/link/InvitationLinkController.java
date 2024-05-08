package com.zfinance.controller.invitation.link;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zfinance.dto.response.invitation.link.InvitationLinkRecord;
import com.zfinance.dto.response.invitation.link.InvitationLinkResponse;
import com.zfinance.mapper.InvitationLinkMapper;
import com.zfinance.services.invitation.link.InvitationLinkService;

@RestController
@RequestMapping("/invitation-link")
@CrossOrigin("*")
public class InvitationLinkController {

	@Autowired
	private InvitationLinkService invitationLinkService;

	@GetMapping
	public InvitationLinkResponse getInvitationLinks() {
		return new InvitationLinkResponse(InvitationLinkMapper.INSTANCE.mapInvitationLinks(invitationLinkService
				.getInvitationLinks()));
	}

	@GetMapping("/{id}")
	public InvitationLinkRecord getInvitationLinkById(@PathVariable String id) {
		return InvitationLinkMapper.INSTANCE.mapInvitationLink(invitationLinkService.getInvitationLinkById(id));
	}

	@PostMapping("/saveInvitationLink")
	public InvitationLinkRecord saveInvitationLink(@RequestBody InvitationLinkRecord invitationLink) {
		return InvitationLinkMapper.INSTANCE.mapInvitationLink(invitationLinkService.saveInvitationLink(
				InvitationLinkMapper.INSTANCE.mapInvitationLinkRecord(invitationLink)));
	}

	@DeleteMapping("/{id}")
	public void deleteInvitationLinkById(@PathVariable String id) {
		invitationLinkService.deleteInvitationLinkById(id);
	}

}
