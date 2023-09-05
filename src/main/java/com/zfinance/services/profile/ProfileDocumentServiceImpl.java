package com.zfinance.services.profile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zfinance.enums.FileStatusEnum;
import com.zfinance.exceptions.DataNotFoundException;
import com.zfinance.orm.profile.ProfileDocument;
import com.zfinance.orm.profile.UserProfileDocument;
import com.zfinance.repositories.profile.ProfileDocumentRepository;
import com.zfinance.repositories.profile.UserProfileDocumentRepository;

@Service
public class ProfileDocumentServiceImpl implements ProfileDocumentService {

	@Autowired
	private ProfileDocumentRepository profileDocumentRepository;

	@Autowired
	private UserProfileDocumentRepository userProfileDocumentRepository;

	@Override
	public List<ProfileDocument> getProfileDocuments() {
		return profileDocumentRepository.findAll();
	}

	@Override
	public List<ProfileDocument> linkPhotoToProfileDocuments(String fileId, String type) {
		List<ProfileDocument> profileDocuments = profileDocumentRepository.findAll();

		for (ProfileDocument profileDocument : profileDocuments) {

			// TODO: LINK THE PHOTO FILE TO THE DOCS

			profileDocument.setType(type);
			profileDocumentRepository.save(profileDocument);
		}

		return profileDocumentRepository.findAll();
	}

	@Override
	public List<ProfileDocument> updateProfileTaxIdWithNumber(String documentIdentifier, String type) {
		List<ProfileDocument> profileDocuments = profileDocumentRepository.findAll();

		for (ProfileDocument profileDocument : profileDocuments) {

			profileDocument.setDocumentIdentifier(documentIdentifier);
			profileDocument.setType(type);
			profileDocumentRepository.save(profileDocument);
		}

		return profileDocumentRepository.findAll();
	}

	@Override
	public List<ProfileDocument> viewAllUploadedProfileDocuments(Map<String, ?> payload) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void approveDocument(String documentId) {

		Optional<UserProfileDocument> userProfileDocumentOptional = userProfileDocumentRepository.findById(documentId);
		if (userProfileDocumentOptional.isPresent()) {
			UserProfileDocument userProfileDocument = userProfileDocumentOptional.get();
			userProfileDocument.setStatus(FileStatusEnum.APPROVED.getCode());
		} else {
			throw new DataNotFoundException(UserProfileDocument.class, documentId);
		}
	}

	@Override
	public void declineDocument(String documentId) {
		Optional<UserProfileDocument> userProfileDocumentOptional = userProfileDocumentRepository.findById(documentId);
		if (userProfileDocumentOptional.isPresent()) {
			UserProfileDocument userProfileDocument = userProfileDocumentOptional.get();
			userProfileDocument.setStatus(FileStatusEnum.DECLINED.getCode());
		} else {
			throw new DataNotFoundException(UserProfileDocument.class, documentId);
		}

	}

}
