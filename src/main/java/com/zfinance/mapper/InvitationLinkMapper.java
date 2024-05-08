package com.zfinance.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import com.zfinance.dto.response.invitation.link.InvitationLinkRecord;
import com.zfinance.orm.invitation.link.InvitationLink;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface InvitationLinkMapper {

	InvitationLinkMapper INSTANCE = Mappers.getMapper(InvitationLinkMapper.class);

	public InvitationLinkRecord mapInvitationLink(InvitationLink invitationLink);

	public InvitationLink mapInvitationLinkRecord(InvitationLinkRecord invitationLinkRecord);

	public default Page<InvitationLinkRecord> mapInvitationLinks(Page<InvitationLink> invitationLinks) {
		return invitationLinks.map(this::mapInvitationLink);
	}

	public List<InvitationLinkRecord> mapInvitationLinks(List<InvitationLink> invitationLinks);

}
