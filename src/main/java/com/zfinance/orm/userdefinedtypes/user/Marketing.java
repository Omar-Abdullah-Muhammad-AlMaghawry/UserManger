package com.zfinance.orm.userdefinedtypes.user;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Marketing {

	@Field("promotional_news")
	private Boolean promotionalNews;

	@Field("informational_messages")
	private Boolean informationalMessages;

}
