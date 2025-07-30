package maquina_snacks_archivos.servicio;

import java.util.ArrayList;
import java.util.List;

import maquina_snacks_archivos.dominio.Snack;

public class ServicioSnacksLista implements IServicioSnacks {
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

    public void agregarSnack(Snack snack) {
        snacks.add(snack);
    }

    public void mostrarSnacks() {
        var inventarioSnacks = "";
        for(var snack: snacks) {
            inventarioSnacks += snack.toString() + "\n";
        }
        System.out.println("--- Snacks en el inventario ---");
        System.out.println(inventarioSnacks);
    }

    public List<Snack> getSnacks() {
        return snacks;
    }

}
