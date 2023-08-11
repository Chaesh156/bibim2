package com.chaesh.Global.error.exception;

import com.chaesh.Global.error.ErrorCode;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException{
    private ErrorCode errorCode;

    public BusinessException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
