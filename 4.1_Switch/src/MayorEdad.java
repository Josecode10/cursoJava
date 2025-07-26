import java.util.Scanner;

public class MayorEdad {
    public static void main(String[] args) {
        // Declarar e inicializar la constante que contiene la edad
        final var MAYOR_EDAD = 18;

        // Solicitar al usuario la edad
        System.out.print("Ingresar la edad: ");
        // Capturar el valor ingresado
        var edad = Integer.parseInt(new Scanner(System.in).nextLine());

        if (edad >= MAYOR_EDAD) {
            System.out.print("La persona con " + edad + " años es mayor de edad.");
        }
        else {
            System.out.print("La persona con " + edad + " año(s) es menor de edad.");
        }
    }

}
