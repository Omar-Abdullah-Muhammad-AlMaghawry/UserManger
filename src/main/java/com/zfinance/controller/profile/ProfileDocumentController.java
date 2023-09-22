package com.zfinance.controller.profile;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zfinance.dto.request.profile.FileProfileDocumentDto;
import com.zfinance.dto.request.profile.TaxProfileDocumentDto;
import com.zfinance.dto.response.SuccessResponse;
import com.zfinance.dto.response.profile.ProfileDocumentDto;
import com.zfinance.dto.response.profile.ProfileDocumentsResponse;
import com.zfinance.dto.response.profile.UserProfileDocumentDto;
import com.zfinance.dto.response.profile.UserProfileDocumentsResponse;
import com.zfinance.mapper.ProfileDocumentMapper;
import com.zfinance.mapper.UserProfileDocumentMapper;
import com.zfinance.services.profile.ProfileDocumentService;

@RestController
@RequestMapping("/profile-documents")
@CrossOrigin("*")
public class ProfileDocumentController {

	@Autowired
	private ProfileDocumentService profileDocumentService;

	@GetMapping
	public ProfileDocumentsResponse getProfileDocuments() {

		List<ProfileDocumentDto> profileDocumentDtos = ProfileDocumentMapper.INSTANCE.mapProfileDocuments(
				profileDocumentService.getProfileDocuments());
		ProfileDocumentsResponse profileDocumentsResponse = new ProfileDocumentsResponse();

		profileDocumentsResponse.setDocuments(profileDocumentDtos);

		return profileDocumentsResponse;
	}

	@PostMapping
	public ProfileDocumentsResponse linkPhotoToProfileDocuments(
			@RequestBody FileProfileDocumentDto fileProfileDocumentDto) {
		List<ProfileDocumentDto> profileDocumentDtos = ProfileDocumentMapper.INSTANCE.mapProfileDocuments(
				profileDocumentService.linkPhotoToProfileDocuments(fileProfileDocumentDto.getFileId(),
						fileProfileDocumentDto.getType()));
		ProfileDocumentsResponse profileDocumentsResponse = new ProfileDocumentsResponse();

		profileDocumentsResponse.setDocuments(profileDocumentDtos);

//		SuccessResponse<ProfileDocumentsResponse> successResponse = new SuccessResponse<>();
//		successResponse.setResponse(profileDocumentsResponse);
		return profileDocumentsResponse;
	}

	@PostMapping("/identifier")
	public ProfileDocumentsResponse updateProfileTaxIdWithNumber(
			@RequestBody TaxProfileDocumentDto taxProfileDocumentDto) {
		List<ProfileDocumentDto> profileDocumentDtos = ProfileDocumentMapper.INSTANCE.mapProfileDocuments(
				profileDocumentService.updateProfileTaxIdWithNumber(taxProfileDocumentDto.getDocumentIdentifier(),
						taxProfileDocumentDto.getType()));
		ProfileDocumentsResponse profileDocumentsResponse = new ProfileDocumentsResponse();

		profileDocumentsResponse.setDocuments(profileDocumentDtos);

//		SuccessResponse<ProfileDocumentsResponse> successResponse = new SuccessResponse<>();
//		successResponse.setResponse(profileDocumentsResponse);
		return profileDocumentsResponse;
	}

	@PostMapping("/view")
	public UserProfileDocumentsResponse viewAllUploadedProfileDocuments(@RequestBody Map<String, ?> payload) {
		List<UserProfileDocumentDto> userProfileDocumentDtos = UserProfileDocumentMapper.INSTANCE.mapProfileDocuments(
				profileDocumentService.viewAllUploadedProfileDocuments(payload));
		UserProfileDocumentsResponse userProfileDocumentsResponse = new UserProfileDocumentsResponse();

		userProfileDocumentsResponse.setRecords(userProfileDocumentDtos);

		return userProfileDocumentsResponse;
	}

	@PostMapping("/{documentId}/approve")
	public SuccessResponse<Void> approveDocument(@PathVariable String documentId) {
		profileDocumentService.approveDocument(documentId);
		SuccessResponse<Void> successResponse = new SuccessResponse<>();
		return successResponse;
	}

	@PostMapping("/{documentId}/decline")
	public SuccessResponse<Void> declineDocument(@PathVariable String documentId) {
		profileDocumentService.declineDocument(documentId);
		SuccessResponse<Void> successResponse = new SuccessResponse<>();
		return successResponse;
	}

}
