package com.zfinance.controller.user.role;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zfinance.dto.request.RoleDto;
import com.zfinance.dto.response.ServerError;
import com.zfinance.dto.response.SuccessResponse;
import com.zfinance.dto.response.user.RoleResponse;
import com.zfinance.exceptions.BusinessException;
import com.zfinance.mapper.RoleMapper;
import com.zfinance.services.role.RoleService;

@RestController
@RequestMapping("/roles")

@CrossOrigin("*")
public class RoleController {
	private final RoleService roleService;

	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}

	@GetMapping()
	public RoleResponse getAllRole() {
		return new RoleResponse(roleService.getAll());
	}

	@PostMapping()
	public SuccessResponse<Void> saveRole(@RequestBody RoleDto options) {
		SuccessResponse successResponse = new SuccessResponse<>();
		try {
			roleService.save(RoleMapper.INSTANCE.mapRole(options));
		} catch (BusinessException e) {
			successResponse.setResponse(null);
			ServerError error = new ServerError("Can't Duplicate Role Name!", "409");
			error.setUnknownProperty("null");
			error.setErrors(null);
			successResponse.setError(error);
		}
		return successResponse;
	}
}
