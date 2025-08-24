package zona_fit.presentacion;

import java.util.Scanner;

import zona_fit.datos.ClienteDAO;
import zona_fit.datos.IClienteDAO;
import zona_fit.dominio.Cliente;

public class ZonaFitApp {
    public static void main(String[] args) {
        IClienteDAO clienteDao = new ClienteDAO();
        var teclado = new Scanner(System.in); // Scanner para leer la entrada del usuario
        System.out.println("\nBienvenido a ZonaFit\n");
        var continuar = false; // Variable para controlar el bucle del menú
        while (!continuar) { // Bucle del menú
            var opcion = mostrarMenu(teclado); // Mostrar el menú y obtener la opción del usuario
            switch (opcion) {
                case 1 -> listarClientes(clienteDao); 
                case 2 -> agregarcliente(teclado, clienteDao);
                case 3 -> modificarCliente(teclado, clienteDao);
                case 4 -> eliminarCliente(teclado, clienteDao);
                case 5 -> buscarCliente(teclado, clienteDao);             
                case 6 -> {
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

    static void listarClientes(IClienteDAO clienteDao) {
        System.out.println("\n*** Listar Clientes ***");
        var clientes = clienteDao.listarClientes(); // Llamar al método listarClientes
        clientes.forEach(System.out::println); // Imprimir la lista de clientes usando expresiones lambda
        System.out.println();
    }

    static void agregarcliente(Scanner teclado, IClienteDAO clienteDao) {
        // Agregar cliente
        var nuevoCLiente = new Cliente("Daniel", "Ortiz", 300); // Crear un objeto cliente
        // Llamar al método agregarCliente y pasar el objeto cliente como parámetro
        var agregado = clienteDao.agregarCliente(nuevoCLiente);
        // Verificar si se agregó el cliente
        if (agregado) {
            System.out.println("Cliente agregado." + nuevoCLiente);
        } else {
            System.out.println("El cliente no se pudo agregar." + nuevoCLiente);
        }
    }

    static void modificarCliente(Scanner teclado, IClienteDAO clienteDao) {
        // Modificar cliente
        Se usa el constructor con todos los parámetros para modificar el cliente
        var modificarCliente = new Cliente(5, "Carlos Daniel", "Ortiz", 300);
        var modificado = clienteDao.modificarCliente(modificarCliente);
        if (modificado) {
            System.out.println("Cliente modificado: " + modificarCliente);
        } else {
            System.out.println("El cliente no se modificó: " + modificarCliente);
        }
    }

    static void eliminarCliente(Scanner teclado, IClienteDAO clienteDao) {
        // Eliminar cliente
        var eliminarCliente = new Cliente(5);
        var eliminado = clienteDao.eliminarCliente(eliminarCliente);
        if (eliminado) {
            System.out.println("El cliente fue eliminado: " + eliminarCliente);
        } else {
            System.out.println("No se eliminó cliente: " + eliminarCliente);
        }
    }

    static void buscarCliente(Scanner teclado, IClienteDAO clienteDao) {}

}
