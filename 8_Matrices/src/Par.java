import java.util.Scanner;

public class Par {

    static boolean par(int a) { // Definir función que evaluar si un número es par
        if (a % 2 == 0) { // Con operador ternario = (a % 2 ==0)? true : false;
            return true; // Si el número es par
        }
        else {
            return false; // Si el número es impar
        }
    } // Fin de la función par

    public static void main(String[] args) {  
        var teclado = new Scanner(System.in);

        // Imprimir título
        System.out.println("\n--- Programa que determina si un número par ---\n");

        System.out.print("Ingresar el número: "); // Solicitar le número a evaluar
        var resultado = par(Integer.parseInt(teclado.nextLine())); // Capturar valor, llamar funcion y pasar el argumento como parámetro de la función
        
        // Mostrar resultado de la evaluación
        if (resultado) {
            System.out.print("\n¡El número es par!\n");
        } else {
            System.out.print("\n¡El número no es par!\n");
        }

    } // Fin de la función main
}
