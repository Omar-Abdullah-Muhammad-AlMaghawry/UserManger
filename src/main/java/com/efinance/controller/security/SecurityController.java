package com.efinance.controller.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.efinance.dto.security.MenuHierarchy;
import com.efinance.exceptions.BusinessException;
import com.efinance.services.security.SecurityService;

@RestController
@RequestMapping("/security")
public class SecurityController {

	@Autowired
	private SecurityService securityService;

	@GetMapping("/getUserMenuHierarchy")
	public List<MenuHierarchy> getUserActiveMenuHierarchy(@RequestParam Long userId, @RequestParam Integer menuType)
			throws BusinessException {
		return securityService.getUserActiveMenuHierarchy(userId, menuType);

	}

}
