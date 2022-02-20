package com.vitraya.sample.assignment.exceptions;



public class StudentException extends Exception{
    private String message;
    public StudentException(String message)
    {
        super(message);
        this.message=message;
    }
}
