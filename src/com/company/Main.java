//Diego villarroel
//karen quisbert
//Mauricio Valdivieso
//Mauricio Valdiviesod
package com.company;

import com.company.*;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Veterinary veterinary = new Veterinary();
        Pet cat = new Cat("Cat", "Black", 4, "cat");
        Pet dog = new Dog("Dog", "Black", 5, "dog");
        Pet parrot = new Parrot("Parrot", "Black", 6, "parrot");

        veterinary.add(cat);
        veterinary.add(dog);
        veterinary.add(parrot);
        menu(veterinary);
    }

    public static void menu(Veterinary veterinary){
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        List<Pet> listPet = new ArrayList<>();

        System.out.println("\n" + "WELCOME TO THE VETERINARY SYSTEM");
        do {
            System.out.println("Enter the option you want");
            System.out.println("1 .Register data of the animal   ");
            System.out.println("2 .Show animals given an ID  ");
            System.out.println("3 .Remove animal given an ID ");
            System.out.println("4 .Show all animals ");
            System.out.println("5 .Show animals by type");
            System.out.println("6 .Show reflection given an ID");
            System.out.println("7 .Exit");

            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 1:

                    break;
                case 2:

                    break;
                case 3:
                    deletePet(veterinary, scanner);

                    break;
                case 4:

                    break;
                case 5:
                    String typePetSearch = menuType().toString();
                    String listado = "";


                    Iterator<Pet> it2 = listPet.iterator();
                    Pet tmpAnalicer  = null;

                    while(it2.hasNext()){
                        listPet = (List<Pet>) it2.next();
                        if (tmpAnalicer.getType().equals(typePetSearch)) {
                            listado = listado + tmpAnalicer.toString();
                        }

                    }
                    System.out.println(listado);
                    submenuType();
                    break;
                case 6:
                    System.out.println("Write the pet ID");
                    int id = scanner.nextInt();
                    Pet pet = veterinary.search(id);
                    if(pet != null) {
                        Class<?> petClass = pet.getClass();
                        petMethods(petClass);
                    } else {
                        System.out.println("Invalid ID");
                    }
                    break;
                case 7:
                    System.exit(0);
                    break;
            }
        }while (opcion != 7 );
    }

    public static void petMethods(Class<?> petClass) {
        try {
            Method[] methods = petClass.getMethods();
            System.out.println(petClass.toString());
            System.out.println("methods length: " + methods.length);
            for (int i = 0; i < methods.length; i++) {
                System.out.println((i+1) + ". " + methods[i].toString());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void deletePet(Veterinary veterinary, Scanner scanner){
        System.out.println("Enter pet's ID: ");
        int id = scanner.nextInt();
        if(veterinary.remove(id)){
            System.out.println("Pet deleted");
        }else{
            System.out.println("ID not found");
        }
    }

    //Menu for choice the type de pet a filter
    public static String menuType(){
        Scanner sc = new Scanner(System.in);
        String type;
        String message = "Choice a of the types show";
        System.out.println("Choice a of our types");
        do {
            System.out.println("Types of Pet ");
            System.out.println("1 .dog ");
            System.out.println("2 .cat ");
            System.out.println("3 .parrot ");
            System.out.println("4 .go a menu ");
            System.out.println(message);
            System.out.print("Choice a option input dog or cat or parrot or go a menu\n");
            type = sc.nextLine();
            return type;
        }while ( !type.equals("go a menu"));
    }

    //method for leave a menuType a menuStart o leave of the aplication Pet
    public static void submenuType(){
        Scanner sc = new Scanner(System.in);
        String select = "";

        System.out.println("\n");
        System.out.println("You want to go back to the menu or exit the application");
        System.out.println("yes. Go to menu");
        System.out.println("not. Leave the app");
        System.out.println("\n");
        select = sc.nextLine();
        if (select.toString().equals("yes")){
            System.out.println("entro a s");
        }else if (select.toString().equals("not")) {
            System.out.println("entro a n");
            System.exit(0);
        }else{
            System.out.println("\n");
            System.out.println("value incorrect pleace input yes or not");
            submenuType();
        }
    }
}
