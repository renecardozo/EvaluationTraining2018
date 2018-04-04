package com.company;

public class Validator {

    public Validator(){
    }

    public static ValidationResponses Validate(int number){
        if(number < 0){
            return ValidationResponses.NEGATIVENUMBER;
        }
        if(number >= 100){
            return ValidationResponses.TOOLARGENUMBER;
        }
        return ValidationResponses.OK;
    }

    public static ValidationResponses Validate(String str){
        if(str.isEmpty()){
            return ValidationResponses.EMPTYSTRING;
        }
        if(str.length() > 200){
            return ValidationResponses.TOOLARGESTRING;
        }
        for (int i=0; i< str.length();i++){
             if(isNumber(str.charAt(i))) {
                 return ValidationResponses.STRINGWITHNUMBERS;
             }
        }
        return ValidationResponses.OK;
    }

    public static boolean isNumber(char s) {
        if(s >= 48 && s <= 57)
            return true;
        return false;
    }
}