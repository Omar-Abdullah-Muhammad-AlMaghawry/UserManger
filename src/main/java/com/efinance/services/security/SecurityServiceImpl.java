package com.efinance.services.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.efinance.dto.user.UserDto;
import com.efinance.exceptions.BusinessException;
import com.efinance.orm.security.UserMenuActionData;
import com.efinance.repositories.security.UserMenuActionDataRepository;

@Service
public class SecurityServiceImpl implements SecurityService {

	@Value("${security.usermenuaction.module}")
	private Long module;

	@Autowired
	private UserMenuActionDataRepository userMenuActionDataRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Value("${integration.rst.auth.validate}")
	private String validateTokenUrl;

	@Override
	public UserDto authenticate(String token) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.set("Authorization", token);
			HttpEntity<Void> entity = new HttpEntity<>(null, headers);

			ResponseEntity<UserDto> responseEntity = restTemplate.exchange(validateTokenUrl, HttpMethod.POST, entity,
					UserDto.class);
			return responseEntity.getBody();
		} catch (HttpStatusCodeException ex) {
			if (ex.getStatusCode().equals(HttpStatus.UNAUTHORIZED)) {
				throw ex;
			} else {
				ex.printStackTrace();
				throw new BusinessException("error_authServiceConnectFailed");
			}
		}
	}

	@Override
	public List<UserMenuActionData> getUserMenuActions(Long userId, String menuCode) {
		return userMenuActionDataRepository.findAllByUserIdAndMenuCodeAndModuleId(userId, menuCode, module);
	}

	@Override
	public boolean isUserMenuActionGranted(Long empId, String menuCode, String action) {
		List<UserMenuActionData> employeeMenuActions = userMenuActionDataRepository
				.findAllByEmployeeIdAndMenuCodeAndModuleIdAndAction(empId, menuCode, module, action);
		return employeeMenuActions.isEmpty() ? false : true;
	}

}
