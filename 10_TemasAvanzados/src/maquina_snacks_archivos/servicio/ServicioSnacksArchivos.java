package maquina_snacks_archivos.servicio;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import maquina_snacks_archivos.dominio.Snack;

public class ServicioSnacksArchivos implements IServicioSnacks {
    private final String NOMBRE_ARCHIVO = "snacks.txt";
    // Crear una lista de snacks
    private List<Snack> snacks = new ArrayList<>();

    // Contructor clase
    public ServicioSnacksArchivos() {
        // Creamos el archivo si no existe
        var archivo = new File(NOMBRE_ARCHIVO);
        var existe = false; // Se asume que el archivo no existe
        try {
            existe = archivo.exists();
            if (existe) {
                this.snacks = obtenerSnacks();
            } else { // Creamos el archivo
                // El argumento es el objeto "File"
                var salida = new PrintWriter(new FileWriter(archivo));
                // Si no se cierra el flujo la creación del archivo puede fallar
                salida.close(); // Cerrar el flujo
                // Confirmar la creación
                System.out.println("¡Se ha creado el archivo!\n" + NOMBRE_ARCHIVO + "\n");
            }
        } catch(Exception e) {
            System.out.println("¡Ha ocurrido un error!" + e.getMessage());
        }
        // Si no existe, cargamos algunos snacks iniciales
        if (!existe) { // Si existe es "false" osea que el archivo no existia y apenas se creó (vacio)
            cargarSnacksIniciales();
        }
    } // Fin del constructor "ServicioSnacksArchivos"

    private void cargarSnacksIniciales() {
        this.agregarSnack(new Snack("Papas", 70));
        this.agregarSnack(new Snack("Refresco", 50));
        this.agregarSnack(new Snack("Sandwich", 120));
    }

    private List<Snack> obtenerSnacks() {
        var snacks = new ArrayList<Snack>();
        try {
            // Cargar el archivo y posteriormente leyendo el archivo
            // Regresa una lista de objetos de tipo "String"
            List<String> lineas = Files.readAllLines(Paths.get(NOMBRE_ARCHIVO));
            // Ciclo forEach para leer el archivo
            for(String linea: lineas) {
                // String cadena = "hola,mundo";
                // cadena.split(",") = {"hola","mundo"};
                // Parseo separado por una coma
                String[] lineaSnack = linea.split(",");
                var SnackID = lineaSnack[0];
                var nombre = lineaSnack[1];
                // El método requiere un double como precio
                var precio = Double.parseDouble(lineaSnack[2]);
                // Crear el objeto de la clase Snack
                // Por variable estática la clase asigna el ID
                var snack = new Snack(nombre, precio);
                // Agregar el snack leído a la lista
                snacks.add(snack); 
            }


        } catch(Exception e) {
            System.out.println("¡Error al leer el archivo snacks! " + e.getMessage());
            e.printStackTrace(); // Detalle del error
        }
        return snacks;
    }

    @Override
    public void agregarSnack(Snack snack) {
        // 1. Agregar a la lista en memoria
        this.snacks.add(snack);
        // 2. Guardamos el nuevo snack en el archivo
        this.agregarSnackArchivo(snack);
    }

    private void agregarSnackArchivo(Snack snack) {
        boolean anexar = false; // No existe el archivo
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            // Del valor que tome "anexar" depende si se sobreescribe la información o se anexa
            anexar = archivo.exists();
            // Crear el objeto salida de la clase printwriter que no va a permitir usar el método "println"
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(snack.escribirSnack()); // Escribir el objeto snack en el archivo
            // Para que se escriba la información en el archivo
            salida.close(); 
        } catch(Exception e) {
            System.out.println("¡Error al agregar el snack!" + e.getMessage());
        }

    }

    @Override
    public void mostrarSnacks() {
        System.out.println("--- Snacks en el inventario ----");
        var inventarioSnacks = "";
        for(var snack: this.snacks) {
            inventarioSnacks += snack.toString() + "\n";
        }
        System.out.println(inventarioSnacks);
    }

    @Override
    public List<Snack> getSnacks() {
        return this.snacks;
    }
}
