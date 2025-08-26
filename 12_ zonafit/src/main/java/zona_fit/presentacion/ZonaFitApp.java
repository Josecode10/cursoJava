package zona_fit.presentacion;

import java.util.Scanner;

import zona_fit.datos.ClienteDAO;
import zona_fit.datos.IClienteDAO;
import zona_fit.dominio.Cliente;

public class ZonaFitApp {
    public static void main(String[] args) {
        zonaFitApp();
    }
    
    private static void zonaFitApp(){
        IClienteDAO clienteDao = new ClienteDAO();
        var teclado = new Scanner(System.in); // Scanner para leer la entrada del usuario
        System.out.println("\n*** Bienvenido a ZonaFit ***\n");
        var salir = false; // Variable para controlar el bucle del menú
        while (!salir) { // Bucle del menú
            var opcion = mostrarMenu(teclado); // Mostrar el menú y obtener la opción del usuario
            switch (opcion) {
                case 1 -> listarClientes(clienteDao);
                case 2 -> buscar(teclado, clienteDao);
                case 3 -> agregar(teclado, clienteDao);
                case 4 -> modificar(teclado, clienteDao);
                case 5 -> eliminar(teclado, clienteDao);
                case 6 -> {
                    System.out.println("Has salido del sistema. ¡Hasta luego!");
                    salir = true; // Salir del bucle
                }
                default -> System.out.println("\nOpción no válida\n");
            }
        }
    }

    static int mostrarMenu(Scanner teclado){
        var opcion = 0;
        System.out.print("""
                Qué deseas hacer:
                1) Listar clientes
                2) Buscar cliente
                3) Agregar cliente
                4) Modificar cliente
                5) Eliminar cliente
                6) Salir
                Escoge una opcion:\s""");
        try {
            opcion = Integer.parseInt(teclado.nextLine());
            return opcion;
        } catch (Exception e) {
            System.out.println("\nSe debe ingresar un entero: " + e.getMessage());
        }
        return opcion;
    }
    
    // Métodos para realizar operacion CRUD
    static void listarClientes(IClienteDAO clienteDao) {
        System.out.println("\n*** Listar Clientes ***");
        var clientes = clienteDao.listarClientes(); // Llamar al método listarClientes
        clientes.forEach(System.out::println); // Imprimir la lista de clientes usando expresiones lambda
        System.out.println();
    }

    static void buscar(Scanner teclado, IClienteDAO clienteDao){
        try {
            System.out.println("Ingresar Id: ");
            var id = Integer.parseInt(teclado.nextLine());
            Cliente cliente = new Cliente(id);
            var buscar = clienteDao.buscarClientePorId(cliente);
            if (buscar) {
                System.out.println("Cliente encontrado: " + cliente + "\n");
            } else {
                System.out.println("El cliente no existe: " + cliente + "\n");
            }
        } catch (Exception e) {
            System.out.println("Error al ingresar id: " + e.getMessage() + "\n");
        }
    }

    static void agregar(Scanner teclado, IClienteDAO clienteDao) {
        Cliente nuevoCLiente = crearClienteSinId(teclado); // Crear un nuevo cliente
        if(nuevoCLiente.getNombre()!=null || nuevoCLiente.getApellido()!=null || nuevoCLiente.getMembresia()!=0){
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
        Cliente modificarCliente = crearClienteConId(teclado);
        var modificado = clienteDao.modificarCliente(modificarCliente);
        if (modificado) {
            System.out.println("Cliente modificado: " + modificarCliente);
        } else {
            System.out.println("El cliente no se modificó: " + modificarCliente);
        }
    }

    static void eliminar(Scanner teclado, IClienteDAO clienteDao) {
        // Eliminar cliente
        int id;
        try {
            System.out.print("Ingresar el id del cliente a eliminar: ");
            id = Integer.parseInt(teclado.nextLine());
            var eliminarCliente = new Cliente(id);
            var eliminado = clienteDao.eliminarCliente(eliminarCliente);
            if (eliminado) {
                System.out.println("El cliente fue eliminado: " + eliminarCliente);
            } else {
                System.out.println("No se eliminó cliente: " + eliminarCliente);
            }
        } catch (Exception e) {
            System.out.println("Error al ingresar id: " + e.getMessage());
        }
    }
    
    static Cliente crearClienteSinId(Scanner teclado){
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

    static Cliente crearClienteConId(Scanner teclado){
        Cliente nuevoCLiente = new Cliente();
        try {
            System.out.print("Ingresar ID del cliente: ");
            var id = Integer.parseInt(teclado.nextLine());
            System.out.print("Ingresar nombre: ");
            var nombre = teclado.nextLine();
            System.out.print("Ingresar apellido: ");
            var apellido = teclado.nextLine();
            System.out.print("Ingresar membresia: ");
            var membresia = Integer.parseInt(teclado.nextLine());
            nuevoCLiente.setId(id);
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
