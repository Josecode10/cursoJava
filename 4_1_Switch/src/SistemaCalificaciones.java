import java.util.Scanner;

public class SistemaCalificaciones {
    public static void main(String[] args) {
        // Solicitar calificacion en valor numérico al usuario
        System.out.print("Ingresar calificación (0-10): ");
        
        // Capturar el valor ingresado
        var calNumerica = Double.parseDouble(new Scanner(System.in).nextLine());

        if (calNumerica >= 9 && calNumerica <= 10) {
            System.out.print("La calificación es una A.");
        }
        else if (calNumerica >= 8 && calNumerica < 9) {
            System.out.print("La calificación es una B.");
        }
        else if (calNumerica >= 7 && calNumerica < 8) {
            System.out.print("La calificación es una C.");
        }
        else if (calNumerica >= 6 && calNumerica < 7) { 
            System.out.print("La calificación es una D.");
        }
        else if (calNumerica >= 0 && calNumerica < 6) {
            System.out.print("La calificación es una F.");
        }
        else {
            System.out.print("Valor desconocido.");
        }
        
    }

}
