//Diego villarroel
//karen quisbert
//Mauricio Valdivieso
//Mauricio Valdiviesod
package com.company;

import com.company.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        Veterinary veterinary = new Veterinary();
        Pet dog = new Dog("Dog", "Brown", 8, "dog");
        dog.setId(4);
        Pet cat = new Cat("Cat", "Blue", 5, "cat");
        cat.setId(8);
        Pet parrot = new Parrot("Parrot", "White", 7, "parrot");
        parrot.setId(6);
        Pet dogNew = new Dog("Dog", "Black", 3, "dogNew");
        dog.setId(9);
        Pet catNew = new Cat("Cat", "White", 2, "catNew");
        cat.setId(2);
        Pet parrotNew = new Parrot("Parrot", "Green", 5, "parrotNew");
        parrot.setId(3);

        veterinary.add(dog);
        veterinary.add(cat);
        veterinary.add(parrot);
        veterinary.add(dogNew);
        veterinary.add(catNew);
        veterinary.add(parrotNew);
        menu(veterinary);
    }

    public static void menu(Veterinary veterinary) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        String aux_r;

        System.out.println("\n" + "WELCOME TO THE VETERINARY SYSTEM");

        do {
            System.out.println("Enter the option you want");
            System.out.println("1 .Register data of the animal   ");
            System.out.println("2 .Show animals by ID  ");
            System.out.println("3 .Remove animal given an ID ");
            System.out.println("4 .Show all animals ");
            System.out.println("5 .Show animals by type");
            System.out.println("6 .Show reflection given an ID");
            System.out.println("7 .Update animal given an ID");
            System.out.println("8 .Exit");
            opcion = scanner.nextInt();
            scanner.nextLine();

            int id;
            switch (opcion){
                case 1:
                    System.out.println("-------------REGISTER NEW ANIMAL-----------");
                    System.out.println("Enter the type of animal");
                    aux_r = scanner.nextLine();
                    int ex = verify(aux_r);
                    if(ex == 0){
                        break;
                    }
                    ArrayList <String> datos=new ArrayList<String>();
                    datos=getDatos();
                    switch (ex){
                        case 1:
                            Pet pet1 =  new Dog("Dog",datos.get(0),Integer.parseInt(datos.get(1)),datos.get(2));
                            veterinary.add(pet1);
                            System.out.println("    *** Successful registration !!! ***");
                            break;
                        case 2:
                            Pet pet2 =  new Cat("Cat",datos.get(0),Integer.parseInt(datos.get(1)),datos.get(2));
                            veterinary.add(pet2);
                            System.out.println("    *** Successful registration !!! ***");
                            break;
                        case 3:
                            Pet pet3 =  new Parrot("Parrot",datos.get(0),Integer.parseInt(datos.get(1)),datos.get(2));
                            veterinary.add(pet3);
                            System.out.println("    *** Successful registration !!! ***");
                            break;
                    }
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("Write the pet ID");
                    id = scanner.nextInt();
                    veterinary.showPetById(id);
                    break;
                case 3:
                    deletePet(veterinary, scanner);
                    break;
                case 4:
                    System.out.println("The full list of Pets is:");
                    System.out.println();
                    veterinary.showAll();
                    System.out.println();
                    break;
                case 5:
                    String typePetSearch = menuType().toString();
                    System.out.println(typePetSearch);

                    for(Pet pet: veterinary.getList()) {
                        if (pet.getType().equals(typePetSearch) && pet.getShow()) {
                            System.out.println(pet);
                        }
                    }
                    submenuType();
                    break;
                case 6:
                    System.out.println("Write the pet ID");
                    id = scanner.nextInt();
                    Pet pet = veterinary.search(id);
                    if (pet != null && pet.getShow()) {
                        Class<?> petClass = pet.getClass();
                        petMethods(petClass);
                    } else {
                        System.out.println("Invalid ID");
                    }
                    break;
                case 7:
                    showUpdateMenu(veterinary, scanner);
                    break;
                case 8:
                default:
                    opcion = 8;
                    break;
            }
        } while (opcion != 8);
    }

    private static void showUpdateMenu(Veterinary veterinary, Scanner scanner) {
        String color, name, updatedColor, updatedName;
        int age, updatedAge;

        System.out.println("Update pets\n");
        System.out.println("Enter an id to update your animal data");
        int id = scanner.nextInt();
        scanner.nextLine();

        Pet updatedPet = veterinary.search(id);
        if (updatedPet == null || !updatedPet.getShow()) {
            System.out.println("The pet with id: " + id + " has not been found");
            System.out.println("Enter a key to continue...");
            scanner.nextLine();
        } else {
            age = updatedPet.getAge();
            color = updatedPet.getColor();
            name = updatedPet.getName();

            System.out.println("Your current pet data is showed below: \n");
            System.out.println(updatedPet);

            updatedName = verifyChangeStringMenu("name", scanner);
            updatedColor = verifyChangeStringMenu("color", scanner);
            updatedAge = verifyChangeIntMenu("age", scanner);

            if(updatedName != null){
                name = updatedName;
            }
            if(updatedColor != null){
                color = updatedColor;
            }
            if(updatedAge != -1){
                age = updatedAge;
            }

            switch (updatedPet.getType()) {
                case "Cat":
                    veterinary.updatePet(id, new Cat(updatedPet.getType(), color, age, name));
                    break;
                case "Dog":
                    veterinary.updatePet(id, new Dog(updatedPet.getType(), color, age, name));
                    break;
                case "Parrot":
                    veterinary.updatePet(id, new Parrot(updatedPet.getType(), color, age, name));
                    break;
            }
            System.out.println("Your animal has been successfully saved!");
            System.out.println(veterinary.search(id));
            System.out.println("Enter a key to continue...");
            scanner.nextLine();
        }
    }

    private static int verifyChangeIntMenu(String string, Scanner scanner) {
        int value = -1;
        String choice;
        System.out.println("Do you want to change your pet " + string +"?");
        System.out.println("Y / N");

        choice = scanner.nextLine();
        while (!choice.equals("Y") && !choice.equals("N")) {
            System.out.println("Invalid option...");
            System.out.println("Please enter: Y / N");
            choice = scanner.nextLine();
        }
        if (choice.equals("Y")) {
            System.out.println("Enter a new " + string + ":");
            value = scanner.nextInt();
            scanner.nextLine();
        }
        return value;
    }

    private static String verifyChangeStringMenu(String string, Scanner scanner) {
        String value = null;
        String choice;
        System.out.println("Do you want to change your pet " + string +"?");
        System.out.println("Y / N");

        choice = scanner.nextLine();
        while (!choice.equals("Y") && !choice.equals("N")) {
            System.out.println("Invalid option...");
            System.out.println("Please enter: Y / N");
            choice = scanner.nextLine();
        }
        if (choice.equals("Y")) {
            System.out.println("Enter a new " + string + ":");
            value = scanner.nextLine();
        }
        return value;
    }

    public static void petMethods(Class<?> petClass) {
        try {
            Method[] methods = petClass.getMethods();
            System.out.println(petClass.toString());
            System.out.println("methods length: " + methods.length);
            for (int i = 0; i < methods.length; i++) {
                System.out.println((i + 1) + ". " + methods[i].toString());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static ArrayList<String> getDatos(){
        String aux ;
        Scanner sc = new Scanner(System.in);
        ArrayList<String> datos= new ArrayList<String>();
        System.out.println("Enter the color of the pet");
        aux = sc.nextLine();
        datos.add(aux);
        System.out.println("Enter the age of the pet");
        aux = sc.nextLine();
        datos.add(aux);
        System.out.println("Enter the name of the pet");
        aux = sc.nextLine();
        datos.add(aux);
        return datos;
    }

    public static int verify(String animal){
        boolean exits;
        int pet;
        if(animal.toUpperCase().equals("DOG")){
            exits = true;
            pet = 1;
        }else if(animal.toUpperCase().equals("CAT")){
            exits = true;
            pet = 2;
        }else if (animal.toUpperCase().equals("PARROT")){
            exits = true;
            pet = 3;
        } else{
            exits = false;
            pet = 0;
        }
        if(exits){
            System.out.println("    *** Right animal!!!. There is the selected animal ***\n");
        }else{
            System.out.println("    *** Wrong animal!!!. The selected animal does not exist ***\n");
        }
        return pet;
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
            System.out.println("1 .Dog ");
            System.out.println("2 .Cat ");
            System.out.println("3 .Parrot ");
            System.out.println("4 .go a menu ");
            System.out.println(message);
            System.out.print("Choice a option input Dog or Cat or Parrot or go a menu\n");
            type = sc.nextLine();
            return type;
        } while (!type.equals("go a menu"));
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
