package com.zfinance.repositories.user;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.zfinance.dto.response.user.UserContract;
import com.zfinance.orm.user.User;

public interface UserRepository extends MongoRepository<User, String> {

//	@Aggregation(pipeline = { "{$unwind: \"$members\"}",
//			"{$group: { _id: { contractId: \"$members.contractInfo.id\", contractName: \"$members.contractInfo.name\" }, userCount: { $sum: 1 }, contractIds: { $addToSet: \"$members.contractInfo.id\" } }}" })
	@Aggregation(pipeline = { "{$unwind: \"$members\"}",
			"{$group: { _id: { contractId: { $ifNull: [\"$members.contractInfo.id\", \"0\"] }, contractName: { $ifNull: [\"$members.contractInfo.name\", \"None\"] }, userCount: { $sum: 1 } }}" })
	List<UserContract> groupByFieldTotal();

	// @Aggregation(pipeline = { "{$group: { _id:\"$id\", userCount: { $sum: \"1\" }
	// }}" })

}
