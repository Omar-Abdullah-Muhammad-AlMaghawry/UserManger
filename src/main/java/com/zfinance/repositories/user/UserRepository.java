package com.zfinance.repositories.user;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.zfinance.dto.request.user.UsersFilter;
import com.zfinance.dto.request.user.UsersSort;
import com.zfinance.orm.user.User;

public interface UserRepository extends MongoRepository<User, String> {

	@Query("{ $and: [" + "?#{ [0]?.ids != null ? { 'id': { $in: [0]?.ids } } : {} },"
			+ "?#{ [0]?.email != null ? { 'email': [0]?.email } : {} },"
			+ "?#{ [0]?.banned != null ? { 'banned': [0]?.banned } : {} },"
			+ "?#{ [0]?.active != null ? { 'active': [0]?.active } : {} }" + "] }" + ", $orderby: { "
			+ "?#{ [1]?.createdAt != null ? 'createdAt' : {} } : 1, " + "?#{ [1]?.active != null ? 'active' : {} } : 1 "
			+ "}")
	List<User> searchUsers(UsersFilter filter, UsersSort sort);
}
