package colecciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Listas {
    public static void main(String[] args) {
        // Interfaces son usadas para establecer un contrato
        // Las listas son una interface y no se puede instanciar
        // istanciar = crear objetos
        List<String> miLista = new ArrayList<>();
        miLista.add("Lunes");
        miLista.add("Martes");
        miLista.add("Miercoles");
        miLista.add("Jueves");
        miLista.add("Viernes");
        miLista.add("Sábado");
        miLista.add("Domingo");

        for(String dias: miLista) {
            System.out.println("Día: " + dias);
        }

        // Funciones lambda
        // Función anónima --- poco código (compacta)
        System.out.println("\n --- Iterar en una lista con una función lambda --- \n");
        miLista.forEach(dias -> {
            System.out.println("Día: " + dias);
        });

        System.out.println("\n--- Más simplificado ---\n");
        miLista.forEach(System.out::println);
        
        // Otra forma de crear una lista
        System.out.println("\n--- Otra forma de crear una lista ---\n");
        List<String> nombres = Arrays.asList("jose", "jessi", "irene");
        nombres.forEach(System.out::println);

        
    }

}
