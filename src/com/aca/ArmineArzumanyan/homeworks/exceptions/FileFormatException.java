package com.aca.arminearzumanyan.homeworks.exceptions;

public class FileFormatException extends RuntimeException{
    String message;
    public FileFormatException(String message){
        this.message = message;
    }
}
