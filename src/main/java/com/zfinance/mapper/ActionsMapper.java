package com.zfinance.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import com.zfinance.dto.response.actions.ActionsRecord;
import com.zfinance.orm.actions.Actions;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ActionsMapper {

	ActionsMapper INSTANCE = Mappers.getMapper(ActionsMapper.class);

	public ActionsRecord mapActions(Actions actions);

	public Actions mapActionsRecord(ActionsRecord actionsRecord);

	public default Page<ActionsRecord> mapActions(Page<Actions> actions) {
		return actions.map(this::mapActions);
	}

	public List<ActionsRecord> mapActions(List<Actions> actions);

}
