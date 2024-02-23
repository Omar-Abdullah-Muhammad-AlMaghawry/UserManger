package com.zfinance.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import com.zfinance.dto.response.role.action.RoleActionRecord;
import com.zfinance.orm.role.actions.RoleAction;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleActionMapper {

	RoleActionMapper INSTANCE = Mappers.getMapper(RoleActionMapper.class);

	public RoleActionRecord mapRoleAction(RoleAction roleAction);

	public RoleAction mapRoleActionRecord(RoleActionRecord actionsRecord);

	public default Page<RoleActionRecord> mapRoleActions(Page<RoleAction> roleActions) {
		return roleActions.map(this::mapRoleAction);
	}

	public List<RoleActionRecord> mapRoleActions(List<RoleAction> roleActions);

}
