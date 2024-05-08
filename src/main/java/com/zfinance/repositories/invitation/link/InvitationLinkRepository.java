package com.zfinance.repositories.invitation.link;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zfinance.orm.invitation.link.InvitationLink;

public interface InvitationLinkRepository extends MongoRepository<InvitationLink, String> {

}
