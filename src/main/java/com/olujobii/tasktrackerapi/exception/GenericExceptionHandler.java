package com.olujobii.tasktrackerapi.exception;

import com.olujobii.tasktrackerapi.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GenericExceptionHandler {

    @ExceptionHandler(InvalidTaskDataException.class)
    public ResponseEntity<ErrorResponseDTO> handleInvalidTaskData(InvalidTaskDataException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponseDTO(LocalDateTime.now(),HttpStatus.BAD_REQUEST,ex.getMessage()));
    }
}
