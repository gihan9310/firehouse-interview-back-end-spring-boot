package com.gihanz.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UnauthorizedLoginExceptionResponse {

    private String errorMsg;
    private int errorCode;
}
