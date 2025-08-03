import java.util.Scanner;

public class App {

    static double power(double base) { // Definir función que calcula el cuadrado de un número
        return Math.pow(base, 2); // Calcular el cuadrado de un número usando el método "pow" de la clase "Math"
    } // Fin de la función "power"
    
    static void saludar(String nombre) { // Definir función que saluda
        System.out.print("\nHola, " + nombre + ".\n"); // Imprimir el mensaje de saludo
    } // Fin de la función "saludar"

    public static void main(String[] args) {
        // Funciones en Java

        System.out.println("\nPrograma que calcula el cuadrado de un número\n"); // Imprimir título
        var teclado = new Scanner(System.in); // Crear el objeto de la clase escaner para acceder a los respectivos métodos

        System.out.print("Cómo es su nombre: "); // Solicitar nombre para el saludo
        saludar(teclado.nextLine()); // Capturar nombre del usuario

        System.out.print("\nIngresar el número a elevar al cuadrado: "); // Solicitar el valor la base al usuario
        var base = Double.parseDouble(teclado.nextLine()); // Capturar el valor ingresado por el usuario

        var resultado = power(base); // Declar e iniciar variable para capturar el resultado de la funcion
        System.out.println("Resultado = " + resultado); // Mostrar resultado

    } // Fin de la función "main"

}
