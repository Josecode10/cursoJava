import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        // Imprimir título
        System.out.println("\n*** Aplicación calculadora ***\n");
        // Declar e iniciar valiables para menu y operaciones
        int choice; 
        double a = 0, b = 0;
        // Crear un objeto de tipo scanner
        var teclado = new Scanner(System.in); 

        // Clico para mostrar el menú al usuario
        do {
            // Mostrar menú
            System.out.print("""
                    Menú
                    1) Sumar
                    2) Restar
                    3) Multiplicar
                    4) Dividir
                    5) Salir
                    Escoge una opción:\s""");
            
            // Bloque en caso de que usuario no ingrese valor un entero en el menú
            try {
                // Capturar el valor ingresado por el usuario
                choice = Integer.parseInt(teclado.nextLine());
            } catch (Exception e) {
                System.out.println("\n" + e.getMessage() + "\n");
                choice = 0;
            }

            if (choice >=1 && choice <= 4) {
                var continuar = false;
                while (!continuar) {
                    try {
                        System.out.println("\nIngresar el primer valor (entero): ");
                        a = Double.parseDouble(teclado.nextLine());
                        System.out.println("Ingresar el segundo valor (entero): ");
                        b = Double.parseDouble(teclado.nextLine());
                        continuar = true;
                    } catch (Exception e) {
                        System.out.println("¡Valor inválido! " + e.getMessage() + "\n");
                    }
                }
                
            }
            
            switch (choice) {
                case 1:
                    sumar(teclado, a, b);
                    
                    break;
                case 2:
                    restar(teclado, a , b);

                    break;
                case 3:
                    multiplicar(teclado, a , b);

                    break;
                case 4:
                    dividir(teclado, a , b);

                    break;
                case 5:
                    System.out.println("\nHas salido del programa.\n");

                    break;
                default:
                    System.out.println("\"¡Se debe ingresar un valor entre 1 y 5!\n");
                    break;
            }

        } while(choice != 5);
        // Cerrar el recurso scanner
        teclado.close();
    }

    static void sumar(Scanner teclado, double a, double b) {
        var resultado = a + b;
        System.out.println("Resultado de la suma: " + resultado + "\n");
    }
    
    static void restar(Scanner teclado, double a, double b) {
        var resultado = a - b;
        System.out.println("Resultado de la resta: " + resultado + "\n");
    }

    static void multiplicar(Scanner teclado, double a, double b) {
        var resultado = a * b;
        System.out.println("Resultado de la multipliación: " + resultado + "\n");
    }

    static void dividir(Scanner teclado, double a, double b) {
        if(b == 0) {
            System.out.println("Error: No se puede dividir entre cero.\n");
        } else {
            System.out.println("El resulta de la división es: " + a / b + "\n");
        }
    }

}
