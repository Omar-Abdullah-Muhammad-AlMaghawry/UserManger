package com.zfinance.orm.profile;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Table("zfin_user_profile_file")
public class UserProfileFile {

	@PrimaryKey
	@Column("id")
	private String id;

	@Column("owner_id")
	private String ownerId;

	@Column("media_type")
	private String mediaType;

	@Column("name")
	private String name;

	@Column("url")
	private String url;

	@Column("md5")
	private String md5;

	@Column("sha1")
	private String sha1;

	@Column("size")
	private Long size;

	@Column("used")
	private Boolean used;

	@Column("created_at")
	private String createdAt;

	@Column("expires_at")
	private String expiresAt;

	@Column("tag")
	private String tag;
}
