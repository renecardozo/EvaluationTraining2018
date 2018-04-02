package com.company;
//lizbet virreira
//mayra hidalgo
//MAuricio Valdivieso
//Rodrigo Rivera
//Osvaldo Zurita
//Luis Villarroel
//mayra hidalgo
public class Cat extends Pet{
    //String tipo;
    public Cat(String tipo, String color, int age,String name){
        super("Cat", color, age , name);

    }

    @Override
    public void sound(){
        System.out.println("miau");
    }
    @Override
    public String toString(){
        return super.toString()+
                "tipo" + super.getTipo() +"\n";
    }

}
