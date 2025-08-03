import java.util.Scanner;

public class Estacion {
    public static void main(String[] args) {
        var consola = new Scanner(System.in); // Crear el objeto para acceder a la clase scanner

        System.out.print("Ingresar el número del mes: ");
        var mes = Integer.parseInt(consola.nextLine());

        if (mes == 12 || (mes >= 1 && mes <= 2)) {
            System.out.print("!La estación es invierno!");            
        }
        else if (mes >= 3 && mes <= 5) {
            System.out.print("!La estación es primavera!");            
        }
        else if (mes >= 6 && mes <= 8) {
            System.out.print("!La estación es verano!");            
        }
        else if (mes >= 9 && mes <= 11) {
            System.out.print("!La estación es otoño!");            
        }
        else {
            System.out.print("¡Estación desconocida!");            
        }
        
    }

}
