package com.company;
//Davor Heredia
//Diego villarroel
//karen quisbert
//Diego villarroel
//Rodrigo Rivera

import java.util.ArrayList;
import java.util.List;

public class Veterinary {
    int idactual= 0;
    List<Pet> pets;
    
    public Veterinary(){
        pets = new ArrayList<>();
    }

    public void add (Pet p){
        p.setId(idactual);
        pets.add(p);
        idactual++;
    }

    public void showAll (){
        for(int i =0 ; i< pets.size(); i++){
            if(pets.get(i).getShow()) { 
                System.out.println(pets.get(i));
            }
        }
    }

    public boolean remove(int id){
        for(int i = 0 ; i< pets.size(); i++){
            if(pets.get(i).getId() == id ) {
                pets.get(i).setShow(false);
                return true;
            }
        }
        return false;
    }

    public void updatePet(int i, Pet p){
        Pet toModify;
        toModify = search(i);
        if(toModify != null){
            toModify.setAge(p.getAge());
            toModify.setColor(p.getColor());
            toModify.setType(p.getType());
            toModify.setName(p.getName());
        }

    }


    public void ShowPetById(int id) {
        boolean exits = false;

        for(int i =0 ; i< pets.size(); i++) {
            if(pets.get(i).getId() == id ) {
                exits = true ;
                System.out.print("Name:" + pets.get(i).getName());
                System.out.print("Color:" + pets.get(i).getColor());
                System.out.print("Age:" + pets.get(i).getAge());
                System.out.print("Tipo:" + pets.get(i).getType());
            }
        }
        if(exits = false) {
            System.out.println("The Pet does not exist");
        }
    }


    public Pet search(int id) {
        for(Pet pet: pets){
            if(pet.getId() == id) {
                return pet;
            }
        }
        return null;
    }

    public List<Pet> getList(){
        return pets;
    }

    @Override
    public String toString(){
        return pets.toString();
    }
}
