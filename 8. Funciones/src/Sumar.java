import java.util.Scanner;

public class Sumar {

    static double sumar(double a, double b) { // Definir funcion que suma dos números
        return a + b; // Operacion de suma
    } // Fin de la funcion

    public static void main(String[] args) {
        // Función princial

        var teclado = new Scanner(System.in); // Crear el objeto de clase scanner

        System.out.print("Ingresar el primer número: "); // Solicitar valores
        var a = Double.parseDouble(teclado.nextLine()); // Capturar valores
        System.out.print("Ingresar el segundo número: "); // Solicitar valores
        var b = Double.parseDouble(teclado.nextLine()); // Capturar valores

        System.out.println("\nResultado = " + sumar(a, b) + "\n"); // Llamar la función sumar, pasar parámetros y mostrar el resultado
        
    } // Fin de la función main

}
