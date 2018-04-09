package com.company;

public enum ValidationResponses {
    OK("Everything is OK"),
    NEGATIVENUMBER("The number is negative"),
    TOOLARGENUMBER("The number is too large"),
    STRINGWITHNUMBERS("The input have numbers on it"),
    TOOLARGESTRING("The input is over 200 characters"),
    STRINGTHATISNOTANUMBER("The input have characters that are not on range [0..9]"),
    STRINGTHATHAVENONALPHABETICALCHARACTERS("The input have some characters that are not on range [a-z] or [A-Z]"),
    EMPTYSTRING("The input is empty");
    private String responseMessage;
    ValidationResponses (String message){
        this.responseMessage = message;
    }
    public String getMessage(){
        return responseMessage;
    }
}
