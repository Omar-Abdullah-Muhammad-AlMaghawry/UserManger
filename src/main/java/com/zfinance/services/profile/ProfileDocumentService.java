package com.zfinance.services.profile;

import java.util.List;

import com.zfinance.dto.request.profile.UserProfileDocumentsFilter;
import com.zfinance.orm.profile.ProfileDocument;
import com.zfinance.orm.profile.UserProfileDocument;

public interface ProfileDocumentService {

	public List<ProfileDocument> getProfileDocuments();

	public List<ProfileDocument> linkPhotoToProfileDocuments(String fileId, String type);

	public List<ProfileDocument> updateProfileTaxIdWithNumber(String documentIdentifier, String type);

	public List<UserProfileDocument> viewAllUploadedProfileDocuments(UserProfileDocumentsFilter profileDocumentsFilter);

	public void approveDocument(String documentId);

	public void declineDocument(String documentId);

	public ProfileDocument saveProfileDocument(ProfileDocument profileDocument);

	public UserProfileDocument saveUserProfileDocument(UserProfileDocument userProfileDocument);

}
