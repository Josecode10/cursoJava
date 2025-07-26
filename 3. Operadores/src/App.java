import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //Realizar un programa para saber si el valor proporcionado
        //se encuentra dentro de un rango definido

        int rangoInicial = 0, rangoFinal = 5;

        
        while (true) {
            
            System.out.println("¿Qué quieres hacer?\n1)Ingresar un número\n2)Terminar");
            var seleccion = new Scanner(System.in).next().charAt(0);
            
            if (seleccion == '1') {
                System.out.println("Ingresar el valor entero a validar: ");
                var numero = Integer.parseInt(new Scanner(System.in).nextLine());

                if (numero >= rangoInicial && numero <= rangoFinal) {
                    System.out.println("El número " + numero + " está dentro del rango.");
                }
                else {
                    System.out.println("El número " + numero + " está fuera del rango.");
                }
            }

            else if (seleccion == '2' ) {
                System.out.println("Has salido del menú.");
                break;
            } 

            else {
                System.out.println("Has ingresado un valor inválido.");
            }

        }
        
    }

}
