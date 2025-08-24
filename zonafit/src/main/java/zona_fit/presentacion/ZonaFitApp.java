package zona_fit.presentacion;

import java.util.Scanner;

import zona_fit.datos.ClienteDAO;
import zona_fit.datos.IClienteDAO;

public class ZonaFitApp {
    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        var teclado = new Scanner(System.in);
        System.out.println("\nBienvenido a ZonaFit\n");
        var continuar = false; // Variable para controlar el bucle del menú
        while (!continuar) { // Bucle del menú
            var opcion = mostrarMenu(teclado); // Mostrar el menú y obtener la opción del usuario
            switch (opcion) {
                case 1 -> listarClientes(); 
                case 2 -> agregarcliente(teclado);
                case 3 -> modificarCliente(teclado);
                case 4 -> eliminarCliente(teclado);
                case 5 -> {
                    System.out.println("Has salido del sistema. ¡Hasta luego!");
                    continuar = true; // Salir del bucle
                }
                default -> System.out.println("\nOpción no válida\n");
            }
        }


    }

    // Mostrar el menú y devolver la opción seleccionada
    static int mostrarMenu(Scanner teclado){
        var opcion = 0;
        System.out.println("""
                Qué deseas hacer:
                1) Listar clientes
                2) Agregar cliente
                3) Modificar cliente
                4) Eliminar cliente
                5) Salir
                Escoge una opcion:\s
                """);
        try {
            opcion = Integer.parseInt(teclado.nextLine());
            return opcion;
        } catch (Exception e) {
            System.out.println("\nSe debe ingresar un entero: " + e.getMessage());
        }
        return opcion;
    }

    static void listarClientes() {
        IClienteDAO clienteDao = new ClienteDAO(); // Crear un objeto de tipo ClienteDAO para llamar a los métodos de la clase
        System.out.println("\n*** Listar Clientes ***");
        var clientes = clienteDao.listarClientes(); // Llamar al método listarClientes
        clientes.forEach(System.out::println); // Imprimir la lista de clientes usando expresiones lambda
        System.out.println();
    }

    static void agregarcliente(Scanner teclado) {}

    static void modificarCliente(Scanner teclado) {}

    static void eliminarCliente(Scanner teclado) {}

}
