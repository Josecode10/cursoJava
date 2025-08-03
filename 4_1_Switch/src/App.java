import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Crear el objeo consola para llamar los metodos de la clase scanner
        var consola = new Scanner(System.in);

        // Solicitar mes al usuario
        System.out.print("Ingresar el número de mes: ");
        // Capturar el valor ingresado
        var mes = Integer.parseInt(consola.nextLine());

        switch (mes) {
            case 1: case 2: case 12:
                System.out.print("!La estación es invierno!");            
                break;
            case 3: case 4: case 5:
                System.out.print("!La estación es primavera!");            
                break;
            case 6: case 7: case 8:
                System.out.print("!La estación es verano!");            
                break;
            case 9: case 10: case 11:
                System.out.print("!La estación es otoño!");            
                break;
            default:
                System.out.print("¡Estación desconocida!");            
                break;
        }

        // if (mes == 12 || (mes >= 1 && mes <= 2)) {
        //     System.out.print("!La estación es invierno!");            
        // }
        // else if (mes >= 3 && mes <= 5) {
        //     System.out.print("!La estación es primavera!");            
        // }
        // else if (mes >= 6 && mes <= 8) {
        //     System.out.print("!La estación es verano!");            
        // }
        // else if (mes >= 9 && mes <= 11) {
        //     System.out.print("!La estación es otoño!");            
        // }
        // else {
        //     System.out.print("¡Estación desconocida!");            
        // }




        
    }
}