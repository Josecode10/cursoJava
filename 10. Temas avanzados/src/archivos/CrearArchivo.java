package archivos;

// pqt de java: io stands for input/output
import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CrearArchivo {
    public static void main(String[] args) {
        // Proporcionamos el nombre del archivo
        var nombreArchivo = "mi_archivo.txt";
        // Crear un objeto de la clase "File"
        var archivo = new File(nombreArchivo);

        // La clase "FileWriter" exige manejar los errores con la clase IOException
        try { 
            if (archivo.exists()) {
                System.out.print("¡El archivo ya existe!");
            } else {
                // Creamos archivo con la clase "FileWriter"
                // Para poder escribir información y que se guarde usamos la clase "PrintWriter"
                var salida = new PrintWriter(new FileWriter(archivo));
                // Para guardar el archivo en disco duro se usa el método "Close"
                salida.close();
                System.out.println("¡Se ha creado el archivo!");
            }
        } catch(IOException e) {
            System.out.println("¡Error al crear archivo: " + e);
            // Detalle de la excepcion, errores generados en el programa
            e.printStackTrace();
        } finally {
            System.out.println();
        }


    }

}
