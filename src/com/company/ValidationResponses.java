package com.company;

public enum ValidationResponses {
    OK("Everything is OK"),
    NEGATIVENUMBER("The number is negative"),
    TOOLARGENUMBER("The number is too large"),
    STRINGWITHNUMBERS("The string have numbers on it"),
    TOOLARGESTRING("The string is over 200 characters"),
    EMPTYSTRING("The string is empty");
    private String responseMessage;
    ValidationResponses (String message){
        this.responseMessage = message;
    }
    public String getMessage(){
        return responseMessage;
    }
}
