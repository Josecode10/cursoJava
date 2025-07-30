package archivos;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LeerTodo {
    public static void main(String[] args) {
        // Otro método para leer archivos
        var nombreArchivo = "mi_archivo.txt";
        try {
            // Leer todas las líneas del archivo
            List<String> lineas = Files.readAllLines(Paths.get(nombreArchivo));
            System.out.println("Contenido del archivo: ");
            for(var linea: lineas) { // ciclo foreach
                System.out.println(linea);
            }
        } catch(Exception e) {
            System.out.println("¡Error al leer el archivo!: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
