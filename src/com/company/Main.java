//Diego villarroel
//karen quisbert
//Mauricio Valdivieso
//Mauricio Valdiviesod
package com.company;
import java.util.Scanner;

import com.company.*;

import java.lang.reflect.Method;
import java.util.Scanner;

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

    public static void menu(Veterinary veterinary) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        System.out.println("\n" + "WELCOME TO THE VETERINARY SYSTEM");
        do {
            System.out.println("Enter the option you want");
            System.out.println("1 .Register data of the animal   ");
            System.out.println("2 .Show animals given an ID  ");
            System.out.println("3 .Remove animal given an ID ");
            System.out.println("4 .Show all animals ");
            System.out.println("5 .Show animals by type");
            System.out.println("6 .Show reflection given an ID");
            System.out.println("7 .Update animal given an ID");
            System.out.println("8 .Exit");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
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

                    break;
                case 6:
                    System.out.println("Write the pet ID");
                    int id = scanner.nextInt();
                    Pet pet = veterinary.search(id);
                    if (pet != null) {
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
        String color, name, choice, updatedColor, updatedName;
        int age, updatedAge;

        System.out.println("Update pets\n");
        System.out.println("Enter an id to update your animal data");
        int id = scanner.nextInt();
        scanner.nextLine();

        Pet updatedPet = veterinary.search(id);
        if (updatedPet == null) {
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

            switch (updatedPet.getTipo()) {
                case "Cat":
                    veterinary.updatePet(id, new Cat(updatedPet.getTipo(), color, age, name));
                    break;
                case "Dog":
                    veterinary.updatePet(id, new Dog(updatedPet.getTipo(), color, age, name));
                case "Parrot":
                    veterinary.updatePet(id, new Parrot(updatedPet.getTipo(), color, age, name));
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
    public static void deletePet(Veterinary veterinary, Scanner scanner){
        System.out.println("Enter pet's ID: ");
        int id = scanner.nextInt();
        if(veterinary.remove(id)){
            System.out.println("Pet deleted");
        }else{
            System.out.println("ID not found");
        }
    }

    private static void showPrincipalMenu() {
        System.out.println("Welcome to the veterinary");
        System.out.println("Enter the option ");
        System.out.println("1 .Register ");
        System.out.println("2 .Update ");
        System.out.println("3 .Show ");
        System.out.println("4 .Delete ");
        System.out.println("5 .Show all");
        System.out.println("6 .Quit");
    }
}
