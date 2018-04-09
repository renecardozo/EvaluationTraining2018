package com.company;
//Luis Villarroel
//Osvaldo Zurita
//lizbeth virreira
//Rodrigo Rivera
//mayra hidalgo
public class Parrot extends Pet {

    public Parrot(String tipo, String color, int age,String name){
        super("Parrot", color, age, name);

    }

    @Override
    public void sound(){
        System.out.println(PetEnum.PARROT.getAnimalSound());
    }

    @Override
    public String toString(){
        return super.toString()+
                "type: " + super.getType() +"\n";
    }
}
