package com.company;

public class Validator {

    static final int MIN_VALUE_FOR_NUMBER = 0;
    static final int MAX_VALUE_FOR_NUMBER = 100;
    static final int MAX_LENGHT_FOR_STRING = 200;
    static final int MIN_ASCII_VALUE_FOR_NUMBER_CHARACTER_ = 48;
    static final int MAX_ASCII_VALUE_FOR_NUMBER_CHARACTER = 57;

    static final int MIN_ASCII_VALUE_FOR_ALPHABETICAL_UPPERCASE_CHARACTER = 65;
    static final int MAX_ASCII_VALUE_FOR_ALPHABETICAL_UPPERCASE_CHARACTER = 90;
    static final int MIN_ASCII_VALUE_FOR_ALPHABETICAL_LOWERCASE_CHARACTER = 97;
    static final int MAX_ASCII_VALUE_FOR_ALPHABETICAL_LOWERCASE_CHARACTER = 122;

    public Validator(){
    }

    public static ValidationResponses Validate(int number){
        if(number < MIN_VALUE_FOR_NUMBER){
            return ValidationResponses.NEGATIVENUMBER;
        }
        if(number >= MAX_VALUE_FOR_NUMBER){
            return ValidationResponses.TOOLARGENUMBER;
        }
        return ValidationResponses.OK;
    }

    public static ValidationResponses isNumber (String input){

        for(int i = 0; i< input.length(); i++){
            char actual = input.charAt(i);
            if( !isNumber(actual)){
                return ValidationResponses.STRINGTHATISNOTANUMBER;
            }
        }
        return ValidationResponses.OK;

    }

    public static ValidationResponses Validate(String str){
        if(str.isEmpty()){
            return ValidationResponses.EMPTYSTRING;
        }
        if(str.length() > MAX_LENGHT_FOR_STRING){
            return ValidationResponses.TOOLARGESTRING;
        }
        for (int i=0; i< str.length();i++){

            char actual = str.charAt(i);
             if(isNumber(actual) ) {
                 return ValidationResponses.STRINGWITHNUMBERS;
             }
             if(!isAlphabeticalChar(actual)){
                return ValidationResponses.STRINGTHATHAVENONALPHABETICALCHARACTERS;
             }
        }
        return ValidationResponses.OK;
    }

    public static boolean isNumber(char s) {
        if(s >= MIN_ASCII_VALUE_FOR_NUMBER_CHARACTER_ && s <= MAX_ASCII_VALUE_FOR_NUMBER_CHARACTER)
            return true;
        return false;
    }
    public static boolean isAlphabeticalChar(char c){
        if((c >= MIN_ASCII_VALUE_FOR_ALPHABETICAL_UPPERCASE_CHARACTER && c <= MAX_ASCII_VALUE_FOR_ALPHABETICAL_UPPERCASE_CHARACTER) ||
                (c >= MIN_ASCII_VALUE_FOR_ALPHABETICAL_LOWERCASE_CHARACTER && c <= MAX_ASCII_VALUE_FOR_ALPHABETICAL_LOWERCASE_CHARACTER)){
            return true;
        }
        return false;
    }
}