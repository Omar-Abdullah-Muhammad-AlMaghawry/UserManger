package com.zfinance.services.profile;

import java.util.List;
import java.util.Map;

import com.zfinance.orm.profile.ProfileDocument;
import com.zfinance.orm.profile.UserProfileDocument;

public interface ProfileDocumentService {

	public List<ProfileDocument> getProfileDocuments();

	public List<ProfileDocument> linkPhotoToProfileDocuments(String fileId, String type);

	public List<ProfileDocument> updateProfileTaxIdWithNumber(String documentIdentifier, String type);

	public List<UserProfileDocument> viewAllUploadedProfileDocuments(Map<String, ?> payload);

	public void approveDocument(String documentId);

	public void declineDocument(String documentId);

}
