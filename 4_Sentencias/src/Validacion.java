import java.util.Scanner;

public class Validacion {
    public static void main(String[] args) {
        // Revisar si el usuario y contraseña son correctos
        var consola = new Scanner(System.in);

        // Declarar a inicializar usuario y contraseña
        var usuario = "tito";
        var contrasena = "abc123";

        // Soliciar usuario
        System.out.print("Ingresar usuario: ");
        var inputUsuario = consola.nextLine(); // Capturar usuario ingresado

        // Solicitar contraseña
        System.out.print("Ingresar contraseña: ");
        var inputContrasena = consola.nextLine(); // Capturar contraseña ingresada

        // Validad usuario y contraseña
        if (usuario.equals(inputUsuario) && contrasena.equals(inputContrasena)) {
            System.out.print("¡Has ingresado al sistema!"); // Informacion correcta
        } 
        
        else if (usuario.equals(inputUsuario)) {
            System.out.print("¡Contreña es incorrecta!");
        } 
        
        else if (contrasena.equals(inputContrasena)) {
            System.out.print("¡Usuario es incorrecto!");
        } 
        
        else {
            System.out.print("¡Usuario o contraseña incorrectos!"); // Información incorrecta
        }
    }

}
