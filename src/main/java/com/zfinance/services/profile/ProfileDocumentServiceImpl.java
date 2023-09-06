package com.zfinance.services.profile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zfinance.enums.FileStatusEnum;
import com.zfinance.exceptions.DataNotFoundException;
import com.zfinance.mapper.FileMapper;
import com.zfinance.orm.profile.File;
import com.zfinance.orm.profile.ProfileDocument;
import com.zfinance.orm.profile.UserProfileDocument;
import com.zfinance.repositories.profile.FileRepository;
import com.zfinance.repositories.profile.ProfileDocumentRepository;
import com.zfinance.repositories.profile.UserProfileDocumentRepository;

@Service
public class ProfileDocumentServiceImpl implements ProfileDocumentService {

	@Autowired
	private ProfileDocumentRepository profileDocumentRepository;

	@Autowired
	private UserProfileDocumentRepository userProfileDocumentRepository;

	@Autowired
	private FileRepository fileRepository;

	@Override
	public List<ProfileDocument> getProfileDocuments() {
		return profileDocumentRepository.findAll();
	}

	@Override
	public List<ProfileDocument> linkPhotoToProfileDocuments(String fileId, String type) {
		List<ProfileDocument> profileDocuments = profileDocumentRepository.findAll();

		for (ProfileDocument profileDocument : profileDocuments) {

			File file = fileRepository.findById(fileId).get();

			profileDocument.setFile(FileMapper.INSTANCE.mapFileType(file));

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
	public List<UserProfileDocument> viewAllUploadedProfileDocuments(Map<String, ?> payload) {
		// TODO Auto-generated method stub
		return userProfileDocumentRepository.findAll();
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
