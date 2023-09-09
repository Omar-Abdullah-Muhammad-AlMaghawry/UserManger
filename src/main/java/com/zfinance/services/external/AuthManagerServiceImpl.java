package com.zfinance.services.external;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.zfinance.orm.user.User;

@Service
public class AuthManagerServiceImpl implements AuthManagerService {

	@Value("${authmanager.url}")
	private String AUTH_MANAGER_URL;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public void registerUser(User user) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		// Create the request body and set the statusId
		HttpEntity<User> requestEntity = new HttpEntity<>(user, headers);

		restTemplate.exchange(AUTH_MANAGER_URL + "/auth/register", HttpMethod.POST, requestEntity, Void.class);

	}

}
