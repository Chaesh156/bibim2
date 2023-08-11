package com.chaesh.Global.error.exception;

public class ToDoNotExistException extends RuntimeException{
    public ToDoNotExistException(String message){
        super(message);
    }
}
