package colecciones;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Mapa {
    public static void main(String[] args) {
        // Uso de mapas
        // Iniciar un mapa o diccionario
        Map<String, String> persona = new HashMap<>();
        // Asignar llaves y valores al mapa
        persona.put("Nombre", "Manuel");
        persona.put("Apellido", "Colmenares");
        persona.put("Edad", "31");
        persona.put("Edad", "31");
        //Imprimir el mapa
        // Se requiere crear un set
        System.out.println("\n--- Valores del Mapa ---\n");
        persona.entrySet().forEach(System.out::println); 
        
        persona.remove("Nombre");
        persona.put("Edad", "45");
        System.out.println("\n--- Valores del Mapa cambiados ---\n");
        persona.entrySet().forEach(System.out::println);
        
        // Iterar en un mapa
        persona.put("Nombre", "Jessica");
        persona.put("Apellido", "Mendoza");
        persona.put("Edad", "38");
        // Utilizando foreach
        persona.forEach((key, value) -> {
            System.out.println("key: " + key + ", Value: " + value);
        });

    }
}
