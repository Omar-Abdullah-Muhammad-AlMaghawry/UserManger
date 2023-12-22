package com.zfinance.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.zfinance.dto.request.RoleDto;
import com.zfinance.orm.role.Role;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface RoleMapper {

	RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

	public Role mapRole(RoleDto roleDto);
}
