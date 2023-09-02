package com.zfinance.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import com.zfinance.dto.response.user.UserRecord;
import com.zfinance.orm.user.User;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	public UserRecord mapUser(User user);

	public User mapUserRecord(UserRecord userRecord);

	public default Page<UserRecord> mapUserss(Page<User> users) {
		return users.map(this::mapUser);
	}

	public List<UserRecord> mapUsers(List<User> users);

}
