import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        // Mostrar titulo del programa
        System.out.println("*** Calculadora para Java ***");
        
        var salir = false;
        
        while (!salir) {

            // Mostrar menú
            System.out.println("");
            System.out.print("""
                Menu:
                1. Sumar
                2. Restar
                3. Multiplicar
                4. Dividir
                5. Salir
                Escoge una opción:\s""");
            
            // Capturar respuesta del usuario
            var seleccion = (new Scanner(System.in)).nextLine().charAt(0);
            
            // Evaluar respuesta
            switch (seleccion) {
                case '1' -> { // Sumar
                    System.out.print("Ingresar el primer valor: "); // Solicitar 1er valor
                    var primerNumero = Double.parseDouble((new Scanner(System.in)).nextLine()); // Capturar el 1er valor
                    System.out.print("Ingresar el segundo valor: "); // Solicitar 2do valor
                    var segundoNumero = Double.parseDouble((new Scanner(System.in)).nextLine()); // Capturar el 2do valor

                    System.out.print("Resultado = " + (primerNumero + segundoNumero)); // Mostrar resultado
                    
                }
                case '2' -> { // Restar
                    System.out.print("Ingresar el primer valor: "); // Solicitar 1er valor
                    var primerNumero = Double.parseDouble((new Scanner(System.in)).nextLine()); // Capturar el 1er valor
                    System.out.print("Ingresar el segundo valor: "); // Solicitar 2do valor
                    var segundoNumero = Double.parseDouble((new Scanner(System.in)).nextLine()); // Capturar el 2do valor
    
                    System.out.print("Resultado = " + (primerNumero - segundoNumero)); // Mostrar resultado
                }
                case '3' -> { // Multiplicar
                    System.out.print("Ingresar el primer valor: "); // Solicitar 1er valor
                    var primerNumero = Double.parseDouble((new Scanner(System.in)).nextLine()); // Capturar el 1er valor
                    System.out.print("Ingresar el segundo valor: "); // Solicitar 2do valor
                    var segundoNumero = Double.parseDouble((new Scanner(System.in)).nextLine()); // Capturar el 2do valor
    
                    System.out.print("Resultado = " + (primerNumero * segundoNumero)); // Mostrar resultado
                }
                case '4' -> { // Dividir
                    System.out.print("Ingresar el primer valor: "); // Solicitar 1er valor
                    var primerNumero = Double.parseDouble((new Scanner(System.in)).nextLine()); // Capturar el 1er valor
                    System.out.print("Ingresar el segundo valor: "); // Solicitar 2do valor
                    var segundoNumero = Double.parseDouble((new Scanner(System.in)).nextLine()); // Capturar el 2do valor
                    // Validar que el denominador es mayor que cero
                    if (segundoNumero > 0) {
                        System.out.print("Resultado = " + (primerNumero / segundoNumero)); // Mostrar resultado
                    }
                    else {
                        System.out.println("El denominador no puede ser cero");
                    }
                }
                case '5' -> { // Salir de la calculadora
                    System.out.println("¡Has salido de la calculadora!");
                    salir = true;
                }
                default -> System.out.println("¡Valor inválido!"); // ¡Error!
            }
        }
    }

}
