package maquina_snacks_archivos.presentacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import maquina_snacks_archivos.dominio.Snack;
import maquina_snacks_archivos.servicio.IServicioSnacks;
import maquina_snacks_archivos.servicio.ServicioSnacksArchivos;
// import maquina_snacks_archivos.servicio.ServicioSnacksLista;

public class MaquinaSnacks {
    public static void main(String[] args) { maquinaSnacks(); }

    public static void maquinaSnacks() { // Inicio de la aplicación
        var salir = false;
        var teclado = new Scanner(System.in);
        // Creamos el objeto para obtener el servicio de snacks (tipo lista)
        // IServicioSnacks servicioSnacks = new ServicioSnacksLista();
        IServicioSnacks servicioSnacks = new ServicioSnacksArchivos();
        // Lista que va almacenando los productos escogidos por el usuario
        List<Snack> productos = new ArrayList<>();
        System.out.println("*** Máquina de Snacks ***"); // Agregar titulo
        servicioSnacks.mostrarSnacks(); // Mostrar inventario de snacks
        while (!salir) {
            try {
                var opcion = mostrarMenu(teclado);
                salir = ejecutarOpciones(opcion, teclado, productos, servicioSnacks);

            } catch(Exception e) {
                System.out.println("Ocurrio un error: " + e.getMessage());
            } finally {
                System.out.println(); // Un salto de línea después de cada iteración
            }

        }
    }

    private static int mostrarMenu(Scanner teclado) {
        System.out.print("""
                Menu:
                1) Comprar snack
                2) Mostrar ticket
                3) Agregar nuevo snack
                4) Inventario snacks
                5) Salir
                Elige una opción:\s""");

        // Retornar el valor ingresado (int)
        return Integer.parseInt(teclado.nextLine());
    }

    private static boolean ejecutarOpciones(int opcion, Scanner teclado, List<Snack> productos,
                                            IServicioSnacks servicioSnacks) {
        var salir = false;
        switch (opcion) {
            case 1 -> comprarSnack(teclado, productos, servicioSnacks);
            case 2 -> mostrarTicket(productos);
            case 3 -> agregarSnack(teclado, servicioSnacks);
            case 4 -> listarInventarioSnacks(teclado, servicioSnacks);
            case 5 -> {
                System.out.println("¡Has salido del programa!");
                return salir = true;
            }
            default -> System.out.println("¡Opción inválida!");
        }
        return salir;
    }

    private static void listarInventarioSnacks(Scanner teclado, IServicioSnacks servicioSnacks) {
        servicioSnacks.mostrarSnacks();
    }

    private static void comprarSnack(Scanner teclado, List<Snack> productos, IServicioSnacks servicioSnacks) {
        System.out.print("¿Qué snack quieres comprar (id)? ");
        var idSnack = Integer.parseInt(teclado.nextLine());
        // De entrada se asume que el ID no existe
        var snackEncontrado = false;
        // Validar que el snack exista en la lista de snacks
        for(var snack: servicioSnacks.getSnacks()) {
            if (idSnack == snack.getSnackId()) {
                // Agregar el snack a la lista de productos
                productos.add(snack);
                System.out.println("¡Snack agregado a la lista de productos!" + snack);
                snackEncontrado = true;
                break;
            }
        }
        if (!snackEncontrado) {
            System.out.println("¡Snack no fue encontrado!" + idSnack);
        }
    }

    private static void mostrarTicket(List<Snack> productos) {
        var ticket = "*** Ticket de venta ***";
        var total = 0.0;
        for(var producto: productos) {
            ticket += "\n\t-" + producto.getNombre() + " - $" + producto.getPrecio();
            total += producto.getPrecio();
        }
        ticket += "\n\tTotal -> $" + total;
        System.out.println(ticket);
    }

    private static void agregarSnack(Scanner teclado, IServicioSnacks servicioSnacks) {
        // Solicitar al usuario los valores del nuevo snack
        System.out.print("Nombre del snack: ");
        var nombre = teclado.nextLine();
        System.out.print("Precio del snack: ");
        var precio = Double.parseDouble(teclado.nextLine());
        // Se usa el método de la clase "Snacks"
        // El método es estático por lo tanto no se requiere crear un nuevo objeto
        servicioSnacks.agregarSnack(new Snack(nombre, precio));
        System.out.println("¡Snack agregado exitosamente!");
        // Mostrar la nueva lista de snacks
        servicioSnacks.mostrarSnacks();
    }
}
