package com.company;

public enum ValidationResponses {
    OK("Opcion Valida"), FAILNUMBER("Fallo en Numero"), FAILSTRING("Fallo en cadena");
    private String responseMessage;
    ValidationResponses (String message){
        this.responseMessage = message;
    }
    public String getMessage(){
        return responseMessage;
    }
}
