package ventas;

public class PruebaVentas {
    public static void main(String[] args) {
        System.out.println("\n--- Sistema de ventas ---\n"); // Imprimir título de la app

        // --- Camisa
        var camisa = new Producto("Camisa", 60.0); // crear objeto camisa
        // --- Pantalon
        var pantalon = new Producto("Pantalon", 100.0); // Crear objeto pantalon
        // --- Medias
        var medias = new Producto("Medias", 25.0); // Crear objeto pantalon
        // --- Franela
        var franela = new Producto("Franela", 30.0); // Crear objeto franela
        // --- Pantaloneta
        var pantaloneta = new Producto("Pantaloneta", 35.0); // Crear objeto pantaloneta

        //--- Crear una orden ---
        var orden1 = new Orden();

        // Agregar productos
        orden1.agregarProductos(camisa);
        orden1.agregarProductos(pantalon);
        orden1.agregarProductos(pantaloneta);

        // Mostrar orden
        orden1.mostrarOrden();

        //--- Crear otra orden ---
        var orden2 = new Orden();

        // Agregar productos
        orden2.agregarProductos(franela);
        orden2.agregarProductos(medias);
        orden2.agregarProductos(camisa);

        // Mostrar orden
        orden2.mostrarOrden();
        
    }

}
