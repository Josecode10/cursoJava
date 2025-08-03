import java.util.Scanner;

public class MenuIterativo {
    public static void main(String[] args) {
        
        while (true) {
            // Mostrar menu
            System.out.println("");
            System.out.print("""
                            Menu:
                            1. Crear cuenta
                            2. Eliminar cuenta
                            3.Salir sistema
                            Escoge una opcion:\s""");
            
            // Capturar respuesta del usuario
            var seleccion = (new Scanner(System.in)).nextLine();

            // Validar respuesta
            if (seleccion.equals("1")) {
                System.out.println("Has creado una cuenta.");
            } 
            else if (seleccion.equals("2")) {
                System.out.println("Has eliminado una cuenta.");
            }
             else if (seleccion.equals("3")) {
                System.out.println("Has salido del sistema.");
                break;
            } else {
                System.out.println("Opción inválida.");
            }
        }
        
    }

}
