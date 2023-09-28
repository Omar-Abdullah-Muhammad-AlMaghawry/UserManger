package com.zfinance.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import com.zfinance.dto.response.actions.ActionsOfUsersRecord;
import com.zfinance.orm.actions.ActionsOfUsers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ActionsOfUsersMapper {

	ActionsOfUsersMapper INSTANCE = Mappers.getMapper(ActionsOfUsersMapper.class);

	public ActionsOfUsersRecord mapActionsOfUsers(ActionsOfUsers actionsOfUsers);

	public ActionsOfUsers mapActionsOfUsersRecord(ActionsOfUsersRecord actionsOfUsersRecord);

	public default Page<ActionsOfUsersRecord> mapActionsOfUserses(Page<ActionsOfUsers> actionsOfUserses) {
		return actionsOfUserses.map(this::mapActionsOfUsers);
	}

	public List<ActionsOfUsersRecord> mapActionsOfUserses(List<ActionsOfUsers> actionsOfUsers);

}
