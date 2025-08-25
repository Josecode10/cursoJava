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
                case 2 -> agregar(teclado, clienteDao);
                case 3 -> modificar(teclado, clienteDao);
                case 4 -> eliminar(teclado, clienteDao);
                case 5 -> buscar(teclado, clienteDao);             
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
                5) Buscar cliente
                6) Salir
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

    static void agregar(Scanner teclado, IClienteDAO clienteDao) {
        Cliente nuevoCLiente = crearCliente(teclado); // Crear un nuevo cliente
        if(nuevoCLiente.getNombre()!=null && nuevoCLiente.getApellido()!=null && nuevoCLiente.getMembresia()!=0){
            var agregado = clienteDao.agregarCliente(nuevoCLiente); // Agregar cliente
            if (agregado) { // Verificar si se agregó el cliente
                System.out.println("Cliente agregado." + nuevoCLiente);
            } else {
                System.out.println("El cliente no se pudo agregar." + nuevoCLiente);
            }
        } else {
            System.out.println("Valores para crear cliente inválidos.");
        }
    }

    static void modificar(Scanner teclado, IClienteDAO clienteDao) {
        // Modificar cliente
        // Se usa el constructor con todos los parámetros para modificar el cliente
        var modificarCliente = new Cliente(5, "Carlos Daniel", "Ortiz", 300);
        var modificado = clienteDao.modificarCliente(modificarCliente);
        if (modificado) {
            System.out.println("Cliente modificado: " + modificarCliente);
        } else {
            System.out.println("El cliente no se modificó: " + modificarCliente);
        }
    }

    static void eliminar(Scanner teclado, IClienteDAO clienteDao) {
        // Eliminar cliente
        var eliminarCliente = new Cliente(5);
        var eliminado = clienteDao.eliminarCliente(eliminarCliente);
        if (eliminado) {
            System.out.println("El cliente fue eliminado: " + eliminarCliente);
        } else {
            System.out.println("No se eliminó cliente: " + eliminarCliente);
        }
    }

    static void buscar(Scanner teclado, IClienteDAO clienteDao) {
        // Buscar por "id"
        var cliente1 = new Cliente(4);
        System.out.println("Cliente antes de la búsqueda: " + cliente1);
        var encontrado = clienteDao.buscarClientePorId(cliente1);
        if (encontrado) {
            System.out.println("Cliente encontrado: " + cliente1);
        } else {
            System.out.println("No se ha encontrado registro: " + cliente1);
        }
    }
    
    static Cliente crearCliente(Scanner teclado){
        Cliente nuevoCLiente = new Cliente();
        try {
            System.out.print("Ingresar nombre: ");
            var nombre = teclado.nextLine();
            System.out.print("Ingresar apellido: ");
            var apellido = teclado.nextLine();
            System.out.print("Ingresar membresia: ");
            var membresia = Integer.parseInt(teclado.nextLine());
            nuevoCLiente.setNombre(nombre);
            nuevoCLiente.setApellido(apellido);
            nuevoCLiente.setMembresia(membresia);
            return nuevoCLiente;
        } catch (NumberFormatException e) {
            System.out.println("Error: Ingresa un número válido para la membresía.");
        } catch (Exception e) {
            System.out.println("Error al recibir información del cliente: " + e.getMessage());
        }
        return nuevoCLiente;
    }

}
