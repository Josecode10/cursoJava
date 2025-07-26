import java.util.Scanner;

public class NumeroMayor {
    public static void main(String[] args) {
        // Programa para identificar el número mayor
        var consola = new Scanner(System.in);

        System.out.print("Ingresar el primer número: ");
        var numero1 = Integer.parseInt(consola.nextLine());

        System.out.print("Ingresar el segundo número: ");
        var numero2 = Integer.parseInt(consola.nextLine());

        if (numero1 > numero2) {
            System.out.print("!El número mayor es " + numero1 + "!");
        }
        else if (numero1 < numero2) {
            System.out.print("!El número mayor es " + numero2 + "!");
        }
        else {
            System.out.print("!Los número son iguales!");
        }

        // Operador ternario
        var resultado = numero1 > numero2 ? numero1:numero2;

        System.out.print(resultado);

    }

}
