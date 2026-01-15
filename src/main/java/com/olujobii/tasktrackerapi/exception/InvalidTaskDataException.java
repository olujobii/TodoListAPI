package com.olujobii.tasktrackerapi.exception;

public class InvalidTaskDataException extends RuntimeException{

    public InvalidTaskDataException(String message){
        super(message);
    }
}
