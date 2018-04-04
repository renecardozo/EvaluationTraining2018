package com.company;

public class Validator {

    public Validator(){
    }

    public static String Validate(int number){
        String resp = "Passed";
        if(number < 0){
            resp = "The number cant be negative";
        }
        return resp;
    }

    public static String Validate(String str){
        String resp = "Passed";
        if(str.isEmpty()){
            resp = "The field can't be empty";
        }
        if(str.length() > 200){
            resp = "The field can't be too large";
        }
        return resp;
    }
}

/* DEMO
 if(Validator.Validate("Here comes the input to validate").equals("Passed")){
         //Do something
 }else{
         System.out.println(Validator.Validate("The input to validate"));
 }
*/