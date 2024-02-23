package com.zfinance.repositories.actions;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.zfinance.dto.request.actions.ActionsOfUsersFilter;
import com.zfinance.dto.request.actions.ActionsOfUsersSort;
import com.zfinance.orm.actionsOfUsers.ActionsOfUsers;

public interface ActionsOfUsersRepository extends MongoRepository<ActionsOfUsers, String> {

	@Query("{ $and: [" + "?#{ [0]?.actionIds != null ? { 'actionId': { $in: [0]?.actionIds } } : null },"
			+ "?#{ [0]?.userIds != null ? { 'userId': { $in: [0]?.userIds } } : null },"
			+ "?#{ [0]?.userIps != null ? { 'requestInfo.ipAddress': { $in: [0]?.userIps } } : null },"
			+ "?#{ [0]?.hosts != null ? { 'requestInfo.host': { $in: [0]?.hosts } } : null },"
			+ "?#{ [0]?.performedAtFrom != null ? { 'performedAt': { $gte: [0]?.performedAtFrom } } : null },"
			+ "?#{ [0]?.performedAtTo != null ? { 'performedAt': { $lte: [0]?.performedAtTo } } : null }" + "] }"
			+ ", $orderby: { " + "?#{ [1]?.dateCreated != null ? 'performedAt' : null } : 1" + "}")
	List<ActionsOfUsers> searchActionsOfUsers(ActionsOfUsersFilter filter, ActionsOfUsersSort sort);

}
