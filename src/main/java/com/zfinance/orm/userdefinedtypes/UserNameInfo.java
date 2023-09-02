package com.zfinance.orm.userdefinedtypes;

import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@UserDefinedType("user_name_info_type")
public class UserNameInfo {
	
    private String first;
    private String last;
    private String middle;
    
}
