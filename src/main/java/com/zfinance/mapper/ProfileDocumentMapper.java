package com.zfinance.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import com.zfinance.dto.response.profile.ProfileDocumentDto;
import com.zfinance.orm.profile.ProfileDocument;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProfileDocumentMapper {

	ProfileDocumentMapper INSTANCE = Mappers.getMapper(ProfileDocumentMapper.class);

	public ProfileDocumentDto mapProfileDocument(ProfileDocument profileDocument);

	public ProfileDocument mapProfileDocumentDto(ProfileDocumentDto profileDocumentDto);

	public default Page<ProfileDocumentDto> mapProfileDocuments(Page<ProfileDocument> profileDocuments) {
		return profileDocuments.map(this::mapProfileDocument);
	}

	public List<ProfileDocumentDto> mapProfileDocuments(List<ProfileDocument> profileDocuments);

}
