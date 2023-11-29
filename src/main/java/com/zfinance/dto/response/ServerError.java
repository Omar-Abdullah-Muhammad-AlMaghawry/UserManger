package com.zfinance.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class ServerError {
    String message;
    String code;
    String unknownProperty;
    ServerError [] errors;

    public ServerError(String message,String code){
        this.code=code;
        this.message=message;
    }

}
