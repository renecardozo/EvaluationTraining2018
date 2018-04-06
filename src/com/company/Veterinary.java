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
        //p.setId(idactual);
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
            toModify.setTipo(p.getTipo());
            toModify.setName(p.getName());
        }
    }

    public Pet search(int id) {
        Pet p = null;
        for(int i =0 ; i< pets.size(); i++){
            if(pets.get(i).getId() == id)
            {
                p = pets.get(i);
            }
        }
        return p;
    }

    @Override
    public String toString(){
        return pets.toString();
    }
}
