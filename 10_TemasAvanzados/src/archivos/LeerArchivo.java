package archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LeerArchivo {
    public static void main(String[] args) {
        // Leer archivo
        var nombreArchivo = "mi_archivo.txt";
        var archivo = new File(nombreArchivo);
        try {
            System.out.println("Contenido del archivo: ");
            // Abrir archivo para lectura
            var entrada = new BufferedReader(new FileReader(archivo));
            // Leemos línea a línea el archivo
            var linea = entrada.readLine();
            
            // Leer todas las líneas
            // Mientras haya líneas por leer
            while (linea != null) { 
                System.out.println(linea);
                // Antes de terminar el ciclo nos movemos a la siguiente línea
                linea = entrada.readLine();
            }
            // cerrar archivo
            entrada.close();
        } catch (Exception e) {
            System.out.println("¡Error al leer el archivo: " + e);
        } finally {
            System.out.println();
        }



    }

}
