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

	// write your code here
        Veterinary veterinary = new Veterinary();
        //Pet cat = new Cat("Cat", "Black", "2");
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
            //
            //Scanner sc = new Scanner(System.in()()

            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 1:

                    break;
                case 2:

                    break;
                case 3: //Delete
                    System.out.println("Enter pet's ID: ");
                    int id = scanner.nextInt();
                    if(veterinary.remove(id)){
                        System.out.println("Pet deleted");
                        break;
                    }else{
                        System.out.println("ID not found");
                        break;
                    }

                case 4:

                    break;
                case 5:
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
                    break;
                default:
                        opcion = 7;
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

}
