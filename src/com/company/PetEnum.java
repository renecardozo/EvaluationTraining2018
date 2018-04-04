package com.company;

public enum PetEnum{
    DOG("Wow"), CAT("Miau"), PARROT("Hello World");

    private String AnimalSound;

    PetEnum(String AnimalSound){
        this.AnimalSound = AnimalSound;
    }
    public String getAnimalSound(){
        return this.AnimalSound ;
    }
}


