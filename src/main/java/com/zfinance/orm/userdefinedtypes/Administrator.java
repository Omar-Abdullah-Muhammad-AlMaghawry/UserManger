package com.zfinance.orm.userdefinedtypes;

import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@UserDefinedType("administrator_type")
public class Administrator {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    
}
