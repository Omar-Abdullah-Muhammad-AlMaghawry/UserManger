package com.zfinance.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import com.zfinance.dto.response.profile.UserProfileDto;
import com.zfinance.orm.profile.UserProfile;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserProfileMapper {

	UserProfileMapper INSTANCE = Mappers.getMapper(UserProfileMapper.class);

	public UserProfileDto mapUserProfile(UserProfile userProfile);

	public UserProfile mapUserProfileDto(UserProfileDto userProfileDto);

	public default Page<UserProfileDto> mapUserProfiles(Page<UserProfile> userProfiles) {
		return userProfiles.map(this::mapUserProfile);
	}

	public List<UserProfileDto> mapUserProfiles(List<UserProfile> userProfiles);

}
