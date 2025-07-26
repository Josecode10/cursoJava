import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;


public class GeneradorID {
    static void Generador(){ // Crear funcion para generar el código único
        // Crear el objeto teclado de la clase Scanner 
        var teclado = new Scanner(System.in);
        
        System.out.print("Ingresar el nombre: "); // Solicitar nombre al usuario
        var nombre = teclado.nextLine().toUpperCase(); // Caputar valor ingresado por el usuario
        
        System.out.print("Ingresar el apellido: "); // Solicitar apellido al usuario
        var apellido = teclado.nextLine().toUpperCase(); // Caputar valor ingresado por el usuario
        
        System.out.print("Ingresar el año de nacimiento (YYYY): "); // Solicitar año de nacimiento al usuario
        var aNac = teclado.nextLine(); // Caputar valor ingresado por el usuario
        
        var codicoUnico = nombre.substring(0,2) + apellido.substring(0, 2) + aNac.substring(2,4) + new DecimalFormat("####").format(new Random().nextInt(1000, 10000));
         
        System.out.println("El código único es = " + codicoUnico);
    
    }
    public static void main(String[] args) {
        // Generador de ID único 
        // Solicitar nombre y tomar los dos primeros caracteres
        // Hacer lo mismo con el apellido y el año de nacimiento 

        System.out.println("\n--- Programa para generar un ID único ---\n");
        Generador(); // LLamar la función generador


    }

}
