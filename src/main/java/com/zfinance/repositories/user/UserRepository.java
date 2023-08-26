package com.zfinance.repositories.user;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zfinance.orm.user.User;

public interface UserRepository extends CassandraRepository<User, String> {

	@Query("SELECT * FROM ZFIN_User u WHERE " + "(:P_IDS IS NULL OR u.id IN :P_IDS) "
			+ "AND (:P_EMAIL IS NULL OR u.contact.email = :P_EMAIL) "
			+ "AND (:P_EMAIL_VERIFIED IS NULL OR u.contact.emailVerified = :P_EMAIL_VERIFIED) "
			+ "AND (:P_PHONE_NUMBER IS NULL OR u.contact.phoneNumber = :P_PHONE_NUMBER) "
			+ "AND (:P_PHONE_NUMBER_VERIFIED IS NULL OR u.contact.phoneVerified = :P_PHONE_NUMBER_VERIFIED) "
			+ "AND (:P_TEXT IS NULL OR u.email LIKE %:P_TEXT% OR u.phoneNumber LIKE %:P_TEXT% ) "
			+ "AND (:P_BANNED IS NULL OR u.banned = :P_BANNED) " + "AND (:P_ACTIVE IS NULL OR u.active = :P_ACTIVE) "
			+ "AND (:P_ROLES IS NULL OR u.members.role IN :P_ROLES) "
			+ "AND (:P_ORGANIZATION_IDS IS NULL OR u.members.organization.id IN :P_ORGANIZATION_IDS) "
			+ "SORT BY (:P_CREATED_AT AND :P_ATCIVE_SORT)")
	List<User> findUsersByFilter(@Param("P_IDS") List<String> ids, @Param("P_EMAIL") String email,
			@Param("P_EMAIL_VERIFIED") Boolean emailVerified, @Param("P_PHONE_NUMBER") String phone,
			@Param("P_PHONE_NUMBER_VERIFIED") Boolean phoneVerified, @Param("P_TEXT") String text,
			@Param("P_BANNED") Boolean banned, @Param("P_ACTIVE") Boolean active, @Param("P_ROLES") List<String> roles,
			@Param("P_ORGANIZATION_IDS") List<String> organizationIds, @Param("P_CREATED_AT") String createdAt,
			@Param("P_ATCIVE_SORT") String activeSort);
}
