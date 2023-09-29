package com.zfinance.services.profile;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.zfinance.dto.request.profile.UserProfileDocumentsFilter;
import com.zfinance.enums.StatusEnum;
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
	private MongoTemplate mongoTemplate;

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
	public List<UserProfileDocument> viewAllUploadedProfileDocuments(
			UserProfileDocumentsFilter userProfileDocumentsFilter) {
		Criteria criteria = new Criteria();

		// Add userProfileDocumentsFilter criteria based on the
		// userProfileDocumentsFilter
		// object
		if (userProfileDocumentsFilter != null) {
			if (userProfileDocumentsFilter.getUserIds() != null && !userProfileDocumentsFilter.getUserIds().isEmpty()) {
				criteria.and("file.ownerId").in(userProfileDocumentsFilter.getUserIds());
			}
			if (userProfileDocumentsFilter.getStatuses() != null && !userProfileDocumentsFilter.getStatuses()
					.isEmpty()) {
				criteria.and("status").in(userProfileDocumentsFilter.getStatuses());
			}
			// Add other userProfileDocumentsFilter criteria as needed...
		}

		Query query = new Query(criteria);

		// You can apply sorting here if needed
		// query.with(Sort.by(Sort.Order.asc("fieldName")));

		return mongoTemplate.find(query, UserProfileDocument.class);
	}

	@Override
	public void approveDocument(String documentId) {

		Optional<UserProfileDocument> userProfileDocumentOptional = userProfileDocumentRepository.findById(documentId);
		if (userProfileDocumentOptional.isPresent()) {
			UserProfileDocument userProfileDocument = userProfileDocumentOptional.get();
			userProfileDocument.setStatus(StatusEnum.APPROVED.getCode());
			userProfileDocumentRepository.save(userProfileDocument);
		} else {
			throw new DataNotFoundException(UserProfileDocument.class, documentId);
		}
	}

	@Override
	public void declineDocument(String documentId) {
		Optional<UserProfileDocument> userProfileDocumentOptional = userProfileDocumentRepository.findById(documentId);
		if (userProfileDocumentOptional.isPresent()) {
			UserProfileDocument userProfileDocument = userProfileDocumentOptional.get();
			userProfileDocument.setStatus(StatusEnum.DECLINED.getCode());
			userProfileDocumentRepository.save(userProfileDocument);
		} else {
			throw new DataNotFoundException(UserProfileDocument.class, documentId);
		}

	}

	@Override
	public ProfileDocument saveProfileDocument(ProfileDocument profileDocument) {
		return profileDocumentRepository.save(profileDocument);
	}

	@Override
	public UserProfileDocument saveUserProfileDocument(UserProfileDocument userProfileDocument) {
		return userProfileDocumentRepository.save(userProfileDocument);
	}

}
