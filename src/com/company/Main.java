//Diego villarroel
//karen quisbert
//Mauricio Valdivieso
//Mauricio Valdiviesod
package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Veterinary veterinary = new Veterinary();
        //Pet cat = new Cat("Cat", "Black", "2");
        menu();
    }
    public static void menu(){
        int opcion = 0;
        System.out.println("Bien venido a la veterianaria");
        do {
            System.out.println("Ingrese la opcion ");
            System.out.println("1 .Ingresar ");
            System.out.println("2 .Mostrar ");
            System.out.println("3 .Eliminar ");
            System.out.println("4 .Mostrar todo");
            System.out.println("5 .Salir");
            //
            //Scanner sc = new Scanner(System.in()()
            switch (opcion){
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;

                    default:
                        opcion =0;
                        break;

            }
        }while (opcion != 0 );
        System.out.println("Bien venido a la veterianaria");
        System.out.println("ADD Pets");


}
}
