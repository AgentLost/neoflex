package com.example.neoflex.web.handler;

import com.example.neoflex.exception.BadRequestException;
import com.example.neoflex.web.response.BaseWebResponse;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.constraints.NotNull;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BaseWebResponse> handleBadRequestException(@NotNull final BadRequestException exc){
        log.error(exc.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new BaseWebResponse(createErrorMassage(exc)));
    }

    private String createErrorMassage(Exception exc){
        final String message = exc.getMessage();
        log.error(ExceptionHandleUtils.buildErrorMessage(exc));
        return message;
    }
}
