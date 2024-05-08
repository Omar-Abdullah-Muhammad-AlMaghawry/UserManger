package com.zfinance.services.external;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.zfinance.config.filters.TokenAuthorizationFilter;
import com.zfinance.dto.response.user.UserRecord;
import com.zfinance.orm.user.User;

@Service
public class AuthManagerServiceImpl implements AuthManagerService {

	@Value("${authmanager.url}")
	private String AUTH_MANAGER_URL;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private TokenAuthorizationFilter tokenAuthorizationFilter;

	@Override
	public void registerUser(User user) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		// Create the request body and set the statusId
		HttpEntity<User> requestEntity = new HttpEntity<>(user, headers);

		restTemplate.exchange(AUTH_MANAGER_URL + "/auth/register", HttpMethod.POST, requestEntity, Void.class);

	}

	@Override
	public UserRecord getUserFromToken(String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", tokenAuthorizationFilter.getToken());
		HttpEntity<Void> entity = new HttpEntity<>(null, headers);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(AUTH_MANAGER_URL + "/auth/getUserFromToken")
				.queryParam("token", token);

		ResponseEntity<UserRecord> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
				UserRecord.class);
		return response.getBody();

	}

	@Override
	public String getConfigValueByCode(String code) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", tokenAuthorizationFilter.getToken());
		HttpEntity<Void> entity = new HttpEntity<>(null, headers);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(AUTH_MANAGER_URL + "/auth/getConfigValueByCode")
				.queryParam("code", code);

		ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
				String.class);
		return response.getBody();
	}

}
