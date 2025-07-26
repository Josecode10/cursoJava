import java.util.Scanner;

public class App1 {
    public static void main(String[] args) {
        // Validar si un número está dentro de un intervalo
        // Establecer límites del intervalo
        final int MINIMO = 0, MAXIMO = 5;

        // Solicitar el usuario ingresar el número
        System.out.println("Ingresar el número: ");
        // Capturar el número ingresado por el usuario
        var numero = Integer.parseInt(new Scanner(System.in).nextLine());
        // El número está dentro del intervalo si ambos valores son verdaderos
        

        // Informar el resultado de la validacion
        System.out.println("El numero está dentro del intervalo: " + (numero >= MINIMO && numero <= MAXIMO));

    }
}
