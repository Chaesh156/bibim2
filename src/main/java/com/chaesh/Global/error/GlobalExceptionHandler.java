package com.chaesh.Global.error;

import com.chaesh.Global.error.exception.BusinessException;
import com.chaesh.Global.error.exception.DailyPlanNotExistException;
import com.chaesh.Global.error.exception.FirebaseMessagingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    protected ResponseEntity<ErrorResponse> handleBusinessException(BusinessException e) {
        ErrorCode errorCode = e.getErrorCode();
        ErrorResponse errorResponse = ErrorResponse.of(errorCode, LocalDateTime.now());
        errorResponse.setDetail(e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(errorCode.getStatus()));
    }
    @ExceptionHandler
    protected ResponseEntity<ErrorResponse> handleFirebaseMessagingException(FirebaseMessagingException e) {
        ErrorCode errorCode = ErrorCode.PUSH_NOTIFICATION_FAIL;
        ErrorResponse errorResponse = ErrorResponse.of(errorCode, LocalDateTime.now());
        errorResponse.setDetail(e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(errorCode.getStatus()));
    }
}
