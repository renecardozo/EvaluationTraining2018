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
    public void remove(int id){
        for(int i =0 ; i< pets.size(); i++){
            if(pets.get(i).getId() == id )
            {
                pets.get(i).setShow(false);
            }
        }

    }

    public void search(int id) {
        for(int i =0 ; i< pets.size(); i++){
            if(pets.get(i).getId() == id && pets.get(i).getShow())
            {
                pets.get(i).setShow(false);
            }
        }
    }

}
