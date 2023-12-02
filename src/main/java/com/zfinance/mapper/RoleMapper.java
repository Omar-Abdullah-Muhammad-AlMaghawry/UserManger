package com.zfinance.mapper;

import com.zfinance.dto.request.RoleDto;
import com.zfinance.dto.response.actions.ActionsRecord;
import com.zfinance.orm.actions.Actions;
import com.zfinance.orm.role.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface RoleMapper {

    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    public Role mapRole(RoleDto roleDto);
}
