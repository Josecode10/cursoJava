package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class AgregarContenidoArchivo {
    public static void main(String[] args) {
        var teclado = new Scanner(System.in);
        // Agregar contenido a un archivo
        // Variable para determinar si se sobreescribe el archivo o se agrega info al archivo
        var anexar = false;
        //Variable que contiene el nombre del archivo
        var nombreArchivo = "mi_archivo.txt";
        // Crear el objeto "File"
        var archivo = new File(nombreArchivo);
        // Revisar si el archivo existe
        try {
            System.out.println("*** Estado actual del archivo ***");
            mostrarArchivo(nombreArchivo);
            // Verificar si el archivo existe
            // Si existe cambiar el valor de la variable a "true"
            anexar = archivo.exists();
            // Abrir el flujo para escribir
            // Crear los objetos "PrintWriter" y "FileWriter"
            var salida = new PrintWriter(new FileWriter(archivo, anexar));

            // Agregar contenido al archivo
            var nuevoContenido = capturarContenido(teclado);
            // Imprimir lo nuevo en el archivo
            salida.println(nuevoContenido);
            // Cerrar el flujo de escritura
            salida.close();
            System.out.println("¡Se agregó contenido al archivo!");
            System.out.println("*** Estado actual del archivo ***");
            mostrarArchivo(nombreArchivo);
        } catch(Exception e) {
            System.out.println("¡Ha ocurrido un error!" + e.getMessage());
        }
    } // Fin del método main
    
    static String capturarContenido(Scanner teclado) {
        System.out.print("Escribe el contenido a agregar: ");
        return teclado.nextLine();
    }

    static void mostrarArchivo(String archivo) {
        // Mostrar en consola como quedó el archivo
        try {
            List<String> lineas = Files.readAllLines(Paths.get(archivo));
            for(String linea: lineas) {
                System.out.println(linea);
            }
        } catch(Exception e) {
            System.out.println("¡Ha ocurrido un error!" + e);
        } finally {
            System.out.println();
        }
    }


} 
