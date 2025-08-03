import java.util.Scanner;

public class Sentencia1 {
    public static void main(String[] args) {
        System.out.print("Ingresar el número: ");
        var numero = Integer.parseInt(new Scanner(System.in).nextLine());

        if (numero > 0) {
            System.out.print("¡El número es positivo!");
        } else if (numero < 0) {
            System.out.print("¡El número es negativo!");
        } else {
            System.out.print("¡El número es igual a cero!");
        }
    }
}
