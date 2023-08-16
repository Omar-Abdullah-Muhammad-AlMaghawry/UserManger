package com.efinance.dto.response;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UsersRecord {

	private String id;
	private String name;
	private String createdAt;
	private boolean active;
	private boolean banned;
	private String banExpiryDate;
	private UserContract contact;
	private List<UserMemberRecord> members;
}
