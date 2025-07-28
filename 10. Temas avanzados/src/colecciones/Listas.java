package colecciones;

import java.util.ArrayList;
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
        
    }

}
