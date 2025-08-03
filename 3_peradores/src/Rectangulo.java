import java.util.Scanner;

public class Rectangulo {
    public static void main(String[] args) {
        // Calcular el área de un rectángulo
        // Area rectagulo = base * altura

        System.out.print("Ingresar la base del rectángulo: "); // Preguntar base al usuario
        var base = Double.parseDouble(new Scanner(System.in).nextLine()); // Capturar el valor ingresado

        System.out.print("Ingresar la altura del rectángulo: "); // Preguntar altura al usuario
        var altura = Double.parseDouble(new Scanner(System.in).nextLine()); // Capturar el valor ingresado

        System.out.println("El área del rectángulo es: " + base * altura); // Informar resultado

        System.out.println("El perímetro del rectángulo es: " + (base + altura) * 2 );

    }
}
