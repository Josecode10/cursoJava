import java.util.TreeSet;
import java.util.Set;

public class Sets {
    public static void main(String[] args) {
        // Iniciar un set
        // TreeSet -- Se guarda el orden de inserción de los elementos
        Set<String> conjunto = new TreeSet<>();
        // Agregar elementos
        conjunto.add("Carlos");
        conjunto.add("Carlos");
        conjunto.add("Victoria");
        conjunto.add("Karla");
    
        System.out.println("\n-- Elementos del Set --\n");
        conjunto.forEach(System.out::println); // Iterar e imprimir
        
        // Remover elementos
        conjunto.remove("Karla");
        
        System.out.println("\n-- Elementos del Set --\n");
        conjunto.forEach(System.out::println); // Iterar e imprimir
    }
}
