import java.util.Scanner;

public class PromedioCalificaciones {
    public static void main(String[] args) {
        System.out.println("\n**** Promedio de calificaciones ***\n"); // Imprimir título

        System.out.print("Cuántas calificaciones desea agregar: "); // Solicitar cantidad de calificaciones
        var cantidad = Integer.parseInt(new Scanner(System.in).nextLine()); // Capturar cantidad de calificaciones

        double[] calificaciones = new double[cantidad]; // Iniciar y declarar el arreglo calificaciones

        for(var i=0; i < calificaciones.length; i++) { // Realizar ciclos para crear el arreglo de calificaciones
            System.out.print("\nCalificacion[" + i + "] = "); // Solicitar la calificacion al usuario
            calificaciones[i] = Double.parseDouble(new Scanner(System.in).nextLine()); // Capturar la calificación
        }

        System.out.println("\n--- Promedio de calificaciones ---\n"); // Imprimir estación
        
        double total = 0; // Declarar e inicializar el acumulador para sumar las calificaciones

        for(var i=0; i < calificaciones.length; i++) { // Ciclar para sumar las calificaciones
            total += calificaciones[i];
        }

        System.out.println("Promedio de las calificaciones = " + (total / calificaciones.length) + "\n"); // Calcular promedio (Total de las calificaciones / largo del arreglo)
        System.out.println("¡Fin del programa!");


        
    }

}
