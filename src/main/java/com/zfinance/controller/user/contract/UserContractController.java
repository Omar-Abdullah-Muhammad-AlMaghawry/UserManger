package com.zfinance.controller.user.contract;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zfinance.dto.request.PaginationRequestOptions;
import com.zfinance.dto.request.user.UserContractFilter;
import com.zfinance.dto.response.PaginationResponse;
import com.zfinance.dto.response.user.UserContract;
import com.zfinance.services.user.UserService;

@RestController
@RequestMapping("/user-contract")
@CrossOrigin("*")
public class UserContractController {

	@Autowired
	private UserService userService;

	@PostMapping("/view")
	public PaginationResponse<UserContract> searchUsers(
			@RequestBody PaginationRequestOptions<UserContractFilter, Void> paginationRequestOptions) {
		PaginationResponse<UserContract> paginationResponse = new PaginationResponse<UserContract>();
		List<UserContract> userContracts = userService.countUsersByContract(paginationRequestOptions.getFilter()
				.getRole());
		paginationResponse.setRecords(userContracts);
		paginationResponse.setTotalRecords(userContracts.size());
		return paginationResponse;
	}
}
