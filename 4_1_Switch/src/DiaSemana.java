import java.util.Scanner;

public class DiaSemana {
    public static void main(String[] args) {
        // Solicitar día de la semana al usuario
        System.out.print("Ingresar el día de la semana: ");
        // Capturas respuesta del usuario
        var diaSemana = Integer.parseInt(new Scanner(System.in).nextLine());

        // Validar el valor capturado
        switch (diaSemana) {
            case 1 -> System.out.print("Lunes");                
            case 2 -> System.out.print("Martes");
            case 3 -> System.out.print("Miércoles");
            case 4 -> System.out.print("Jueves");
            case 5 -> System.out.print("Viernes");                
            case 6 -> System.out.print("Sábado");                
            case 7 -> System.out.print("Domingo");                
            default -> System.out.print("Valor inválido.");
        }
    }

}
