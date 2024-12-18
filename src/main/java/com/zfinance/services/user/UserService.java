package com.zfinance.services.user;

import java.util.List;

import com.zfinance.dto.request.PaginationRequestOptions;
import com.zfinance.dto.request.profile.NewCredentials;
import com.zfinance.dto.request.user.PayeeInvitationBody;
import com.zfinance.dto.request.user.UserCreateBody;
import com.zfinance.dto.request.user.UsersFilter;
import com.zfinance.dto.request.user.UsersSort;
import com.zfinance.dto.response.user.Invitation;
import com.zfinance.dto.response.user.UserContract;
import com.zfinance.orm.user.User;

public interface UserService {

	public List<User> searchUsers(PaginationRequestOptions<UsersFilter, UsersSort> paginationRequestOptions);

	public List<UserContract> countUsersByContract(String role);

	public List<User> findAllUser();

	public User create(UserCreateBody userCreateBody);

	public void delete(String userId);

	public void unban(String userId);

	public void toggleActivate(String userId, Boolean active);

	public User getUserById(String userId);

	public void updatePassword(String userId, NewCredentials userPassword);

	public User saveUser(User user);

	public List<Invitation> invitePayees(PayeeInvitationBody payeeInvitationBody);

}
