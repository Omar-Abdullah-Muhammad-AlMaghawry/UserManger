package com.zfinance.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import com.zfinance.dto.response.profile.UserProfileDocumentDto;
import com.zfinance.orm.profile.UserProfileDocument;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserProfileDocumentMapper {

	UserProfileDocumentMapper INSTANCE = Mappers.getMapper(UserProfileDocumentMapper.class);

	public UserProfileDocumentDto mapUserProfileDocument(UserProfileDocument userProfileDocument);

	public UserProfileDocument mapUserProfileDocumentDto(UserProfileDocumentDto userProfileDocumentDto);

	public default Page<UserProfileDocumentDto> mapUserProfileDocuments(
			Page<UserProfileDocument> userProfileDocuments) {
		return userProfileDocuments.map(this::mapUserProfileDocument);
	}

	public List<UserProfileDocumentDto> mapProfileDocuments(List<UserProfileDocument> userProfileDocuments);

}
