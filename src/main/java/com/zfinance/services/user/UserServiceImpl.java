package com.zfinance.services.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.zfinance.orm.role.Role;
import com.zfinance.repositories.role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.zfinance.dto.request.profile.NewCredentials;
import com.zfinance.dto.request.user.UserCreateBody;
import com.zfinance.dto.request.user.UsersFilter;
import com.zfinance.dto.request.user.UsersSort;
import com.zfinance.dto.response.user.UserContract;
import com.zfinance.exceptions.BusinessException;
import com.zfinance.exceptions.DataNotFoundException;
import com.zfinance.orm.organization.Organization;
import com.zfinance.orm.profile.UserProfile;
import com.zfinance.orm.user.User;
import com.zfinance.orm.userdefinedtypes.user.UserContact;
import com.zfinance.orm.userdefinedtypes.user.UserContractInfo;
import com.zfinance.orm.userdefinedtypes.user.UserMemberRecord;
import com.zfinance.orm.userdefinedtypes.user.UserOrganization;
import com.zfinance.orm.userdefinedtypes.user.UserSecurity;
import com.zfinance.repositories.user.UserRepository;
import com.zfinance.services.database.sequence.SequenceGeneratorService;
import com.zfinance.services.external.AuthManagerService;
import com.zfinance.services.organization.OrganizationService;
import com.zfinance.services.profile.UserProfileService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserProfileService userProfileService;

	@Autowired
	private OrganizationService organizationService;

	@Autowired
	private AuthManagerService authManagerService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@Override
	public List<User> searchUsers(UsersFilter usersFilter, UsersSort usersSort) {

		Criteria criteria = new Criteria();

		// Add usersFilter criteria based on the usersFilter object
		if (usersFilter != null) {
			if (usersFilter.getIds() != null && !usersFilter.getIds().isEmpty()) {
				criteria.and("id").in(usersFilter.getIds());
			}
			if (usersFilter.getEmail() != null) {
				criteria.and("email").is(usersFilter.getEmail());
			}
			if (usersFilter.getEmailVerified() != null) {
				criteria.and("contact.emailVerified").is(usersFilter.getEmailVerified());
			}
			if (usersFilter.getPhone() != null) {
				criteria.and("contact.phoneNumber").is(usersFilter.getPhone());
			}
			if (usersFilter.getPhoneVerified() != null) {
				criteria.and("contact.phoneVerified").is(usersFilter.getPhoneVerified());
			}
			if (usersFilter.getText() != null) {
				// Example of adding text search criteria (you can customize this)
				criteria.orOperator(Criteria.where("name").regex(usersFilter.getText(), "i"), Criteria.where("email")
						.regex(usersFilter.getText(), "i"));
			}
			if (usersFilter.getBanned() != null) {
				criteria.and("banned").is(usersFilter.getBanned());
			}
			if (usersFilter.getActive() != null) {
				criteria.and("active").is(usersFilter.getActive());
			}
			if (usersFilter.getRoles() != null && !usersFilter.getRoles().isEmpty()) {
				criteria.and("members.role").in(usersFilter.getRoles());
			}
			if (usersFilter.getIdentificationStatus() != null) {
				criteria.and("members.organization.identificationStatus").is(usersFilter.getIdentificationStatus());
			}
			if (usersFilter.getOrganizationIds() != null && !usersFilter.getOrganizationIds().isEmpty()) {
				criteria.and("members.organization.id").in(usersFilter.getOrganizationIds());
			}
			if (usersFilter.getIban() != null) {
				criteria.and("contact.iban").is(usersFilter.getIban());
			}
			if (usersFilter.getTid() != null) {
				criteria.and("contact.tid").is(usersFilter.getTid());
			}
			if (usersFilter.getVirtualAccountNumber() != null) {
				criteria.and("contact.virtualAccountNumber").is(usersFilter.getVirtualAccountNumber());
			}
			if (usersFilter.getPersonalId() != null) {
				criteria.and("members.organization.personType").is(usersFilter.getPersonalId());
			}
		}

		Query query = new Query(criteria);

		// Apply sorting
		if (usersSort != null) {
			if (usersSort.getCreatedAt() != null) {
				if (usersSort.getCreatedAt().equalsIgnoreCase("asc")) {
					query.with(Sort.by(Sort.Order.asc("created_at")));
				} else if (usersSort.getCreatedAt().equalsIgnoreCase("desc")) {
					query.with(Sort.by(Sort.Order.desc("created_at")));
				}
			}
			if (usersSort.getActive() != null) {
				if (usersSort.getActive().equalsIgnoreCase("asc")) {
					query.with(Sort.by(Sort.Order.asc("active")));
				} else if (usersSort.getActive().equalsIgnoreCase("desc")) {
					query.with(Sort.by(Sort.Order.desc("active")));
				}
			}
		}

		return mongoTemplate.find(query, User.class);
	}

	@Override
	public List<UserContract> countUsersByContract(String role) {
		// Add match operation to filter by role
		// Add match operation to filter by role
//		MatchOperation matchOperation = Aggregation.match(Criteria.where("members.role").is(role));
//
////		@Aggregation(pipeline = {
////	            "{$group: { _id: \"$groupByField\", total: { $sum: \"$someValue\" } }}"
////	    })
////	    List<YourResultClass> groupByFieldTotal();
//		// Unwind members array
//		UnwindOperation unwindOperation = Aggregation.unwind("members");
//
//		// Group by contract ID and name
//		GroupOperation groupOperation = Aggregation.group("members.contractInfo.id", "members.contractInfo.name")
//				.count().as("userCount");
//
//		// Aggregation pipeline
//		Aggregation aggregation = Aggregation.newAggregation(matchOperation, unwindOperation, groupOperation);
//
//		// Use $getField to access fields with dots in their names
//		mongoTemplate.aggregate(aggregation, "zfin_user", Object.class);

		List<UserContract> userContracts = userRepository.groupByFieldTotal();

		return userContracts;
	}

	@Override
	public List<User> findAllUser() {
		return userRepository.findAll();
	}

	@Override
	public void create(UserCreateBody userCreateBody) {
		User user = new User();
		UserContact userContact = new UserContact();
		UserMemberRecord memberRecord = new UserMemberRecord();
		UserOrganization userOrganization = new UserOrganization();
		UserContractInfo userContractInfo = new UserContractInfo();
		Role role=roleRepository.findById(userCreateBody.getRole()).get();
		List<UserMemberRecord> memberRecords = new ArrayList<UserMemberRecord>();

		String emailOrPhoneNember = userCreateBody.getLogin();

		if (emailOrPhoneNember.contains("@")) {
			user.setEmail(emailOrPhoneNember);
			userContact.setEmail(emailOrPhoneNember);
		} else {
			userContact.setPhoneNumber(emailOrPhoneNember);
		}

		user.setId(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME));
		user.setContact(userContact);
		user.setCreatedAt((new Date()).toString());
		user.setActive(true);
		user.setBanned(false);
		user.setUserRole(role);
		memberRecord.setRole(userCreateBody.getRole());
		userOrganization.setId(userCreateBody.getOrganizationId());
		if (userCreateBody.getOrganizationId() != null) {
			Organization organization = organizationService.findOrganizationById(userCreateBody.getOrganizationId());
			userOrganization.setStatus(organization.getStatus());
			userOrganization.setIdentificationStatus(organization.getIdentificationStatus());
			userOrganization.setOrganizationStatus(organization.getStatus());
			userOrganization.setMessage(organization.getMessage());
			userOrganization.setName(organization.getName());
			userOrganization.setType(organization.getType());
			userContractInfo = organization.getContractInfo();
			userContractInfo.setPersonType(userCreateBody.getLegalType());
		}
		memberRecord.setId(UUID.randomUUID().toString());
		memberRecord.setContractInfo(userContractInfo);
		memberRecord.setOrganization(userOrganization);
//		user.setRole(userCreateBody.getRole());
//		user.setOrganizationId(userCreateBody.getOrganizationId());
//		user.setLegalType(userCreateBody.getLegalType());
		memberRecords.add(memberRecord);
		user.setMembers(memberRecords);

		String encPassword = passwordEncoder.encode(userCreateBody.getPassword());
		user.setEncPassword(encPassword);

		authManagerService.registerUser(user);
//		user = userRepository.save(user);

		UserProfile userProfile = new UserProfile();
		userProfile.setId(sequenceGeneratorService.generateSequence(UserProfile.SEQUENCE_NAME));
		userProfile.setUserId(user.getId());
		userProfile.setContact(userContact);
		UserSecurity userSecurity = new UserSecurity();
		userProfile.setSecurity(userSecurity);

		userProfileService.saveUserProfile(userProfile);

	}

	@Override
	public void delete(String id) {
		userRepository.deleteById(id);

	}

	@Override
	public void unban(String userId) {
		Optional<User> userOptional = userRepository.findById(userId);
		if (userOptional.isPresent()) {
			User user = userOptional.get();
			user.setBanned(false);
			userRepository.save(user);
		} else {
			throw new DataNotFoundException(User.class, userId);
		}
	}

	@Override
	public void toggleActivate(String userId, Boolean active) {
		Optional<User> userOptional = userRepository.findById(userId);

		if (userOptional.isPresent()) {
			User user = userOptional.get();
			user.setActive(active);
			userRepository.save(user);
		} else {
			throw new DataNotFoundException(User.class, userId);
		}
	}

	@Override
	public User getUserById(String userId) {
		Optional<User> userOptional = userRepository.findById(userId);
		if (userOptional.isPresent()) {
			return userOptional.get();
		} else {
			throw new DataNotFoundException(User.class, userId);
		}
	}

	@Override
	public void updatePassword(String userId, NewCredentials userPassword) {
		User user = this.getUserById(userId);
		if (passwordEncoder.matches(userPassword.getCurrentUserPassword(), user.getEncPassword())) {
			String newEncPassword = passwordEncoder.encode(userPassword.getNewUserPassword());
			user.setEncPassword(newEncPassword);
			userRepository.save(user);
		} else {
			throw new BusinessException("error_invalidPassword");
		}
	}

	@Override
	public User saveUser(User user) {

		if (user != null) {
			if (user.getId() != null) {
				User userToBeUpdated = getUserById(user.getId());
				user.setEmail(userToBeUpdated.getEmail());
				user.setEncPassword(userToBeUpdated.getEncPassword());
			}
			// TODO: NEED TO BE CHECKED THE PERSON TYPE
			if (user.getMembers() != null && !user.getMembers().isEmpty() && user.getMembers().get(0)
					.getContractInfo() != null && user.getMembers().get(0).getContractInfo().getPersonType() != null) {
				UserProfile userProfile = userProfileService.getUserProfileByUserId(user.getId());
				userProfile.setType(user.getMembers().get(0).getContractInfo().getPersonType());
				userProfileService.saveUserProfile(userProfile);
			}
		}
		return userRepository.save(user);
	}

}
