package maquina_snacks;

import java.util.ArrayList;
import java.util.List;

public class Snacks {
    // Atributos
    private static final List<Snack> snacks;

    // Bloque static inicializador
    static { // Inicializar atributos estáticos o cualquiera del contexto estático
        snacks = new ArrayList<>();
        snacks.add(new Snack("Frituras", 10));
        snacks.add(new Snack("Barra de chocolate", 15));
        snacks.add(new Snack("Paquete de dulces", 17));
        snacks.add(new Snack("Gaseosa", 20));
    }

    public static void agregarSnack(Snack snack) {
        snacks.add(snack);
    }

    public static void mostrarSnacks() {
        var inventarioSnacks = "";
        for(var snack: snacks) {
            inventarioSnacks += snack.toString() + "\n";
        }
        System.out.println("--- Snacks en el inventario ---");
        System.out.println(inventarioSnacks);
    }

    public static List<Snack> getSnacks() {
        return snacks;
    }

}
