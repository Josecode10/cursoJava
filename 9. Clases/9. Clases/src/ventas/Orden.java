package ventas;

public class Orden {
    // Definir atributos

    private final int idOrden; // No se modificará posteriormente
    // Cada objeto orden tendrá un arreglo específico
    // Cada objeto tiene una variable de tipo arreglo
    private Producto[] productos;
    private int contadorProductos; // Valor por defecto es cero (int)
    private static final int MAX_PRODUCTOS = 10; // Las ordenes no pueden tener más de 10 productos
    private static int contadorOrdenes; // Valor por defecto es cero (int)

    // Definir métodos
    public Orden() { // Constructor
        // Asigna un ID a la orden
        this.idOrden = ++Orden.contadorOrdenes; 
        // Inicializar el arreglo de objetos producto
        this.productos = new Producto[Orden.MAX_PRODUCTOS]; 
    }

    public void agregarProductos(Producto producto) {
        // Validar la cantidad de producto en la orden
        if (this.contadorProductos < Orden.MAX_PRODUCTOS) {
            // Se aplica postincremento ya que el primer index de un arrego es cero
            this.productos[this.contadorProductos++] = producto; // Menor o igual a 10
        } else {
            // Más de 10 productos en la orden
            System.out.println("Se ha superado el máximo de productos: " + Orden.MAX_PRODUCTOS); 
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (var i=0; i < this.contadorProductos; i++) {
            // "i" es el objeto producto que se está recorriendo
            // Se llama al método de producto (getPrecio)
            total += productos[i].getPrecio(); 
        }
        return total;
    }

    public void mostrarOrden() {
        System.out.println("Id Orden: " + this.idOrden);
        System.out.println("\tTotal de la orden: " + this.calcularTotal());
        System.out.println("\tProductos de la orden: ");
        // Recorrer la orden
        for(var i=0; i < this.contadorProductos; i++) {
            System.out.println("\t\t" + this.productos[i]);
        }
    }

}
