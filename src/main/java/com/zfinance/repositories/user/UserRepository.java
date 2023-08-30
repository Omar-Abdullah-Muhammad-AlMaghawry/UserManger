package com.zfinance.repositories.user;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zfinance.orm.user.User;

public interface UserRepository extends CassandraRepository<User, String> {

//	@Query("SELECT * FROM User WHERE " + "( :ids IS NULL OR id IN :ids ) "
//			+ "AND (:P_EMAIL IS NULL OR contact.email = :P_EMAIL) "
//			+ "AND (:P_EMAIL_VERIFIED IS NULL OR contact.emailVerified = :P_EMAIL_VERIFIED) "
//			+ "AND (:P_PHONE_NUMBER IS NULL OR contact.phoneNumber = :P_PHONE_NUMBER) "
//			+ "AND (:P_PHONE_NUMBER_VERIFIED IS NULL OR contact.phoneVerified = :P_PHONE_NUMBER_VERIFIED) "
//			+ "AND (:P_TEXT IS NULL OR contact.email LIKE '%' || :P_TEXT || '%' OR contact.phoneNumber LIKE '%' || :P_TEXT || '%') "
//			+ "AND (:P_BANNED IS NULL OR banned = :P_BANNED) " + "AND (:P_ACTIVE IS NULL OR active = :P_ACTIVE) "
//			+ "AND (:P_ROLES IS NULL OR members.role IN :P_ROLES) "
//			+ "AND (:P_ORGANIZATION_IDS IS NULL OR members.organization.id IN :P_ORGANIZATION_IDS) "
//			+ "ORDER BY (:P_CREATED_AT AND :P_ATCIVE_SORT)")
	@Query("SELECT * FROM ZFIN_USER " + "WHERE id IN (:p_ids) " + "AND contact.email = :p_email "
			+ "AND contact.emailVerified = :p_email_verified " + "AND contact.phoneNumber = :p_phone_number "
			+ "AND contact.phoneVerified = :p_phone_number_verified "
			+ "AND contact.email LIKE '%' || :p_text || '%' OR contact.phoneNumber LIKE '%' || :p_text || '%' "
			+ "AND banned = :p_banned " + "AND active = :p_active " + "AND role IN :p_roles "
			+ "ORDER BY (:p_created_at AND :p_atcive_sort) " + "ALLOW FILTERING")
	List<User> findUsersByFilter(@Param("p_ids") List<String> ids, @Param("p_email") String email,
			@Param("p_email_verified") Boolean emailVerified, @Param("p_phone_number") String phone,
			@Param("p_phone_number_verified") Boolean phoneVerified, @Param("p_text") String text,
			@Param("p_banned") Boolean banned, @Param("p_active") Boolean active, @Param("p_roles") List<String> roles,
			@Param("p_created_at") String createdAt, @Param("p_atcive_sort") String activeSort);
}
