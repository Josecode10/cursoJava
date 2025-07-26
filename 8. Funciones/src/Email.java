import java.util.Scanner;

public class Email {
    static void generadorEmail(){ // Crear la función para generar emails
        
        var teclado = new Scanner(System.in); // Crear el objeto teclado de la clase Scanner
        var dominio = "@outlook.com";

        System.out.print("Ingresar nombre: "); // Solicitar nombre al usuario
        var nombre = teclado.nextLine().toLowerCase(); // Capturar nombre y convertirlo a minúscula
        System.out.print("Ingresar apellido: "); // Solicitar nombre al usuario
        var apellido = teclado.nextLine().toLowerCase(); // Capturar apellido y convertirlo a minúscula

        var emailUnico = nombre + "." + apellido + dominio; // Concatener las variables para crear el correo

        System.out.println("\nTu correo es " + emailUnico + "\n");

    }

    public static void main(String[] args) {
        // Generador de email
        // Solicitar nombre (minuscula)
        // Mismo proceso con apellido
        // Punto intermedio
        
        // Imprimir título
        System.out.println("\n--- Generador de Email ---\n");

        generadorEmail(); // LLamar la funcion generador de email

    }

}
