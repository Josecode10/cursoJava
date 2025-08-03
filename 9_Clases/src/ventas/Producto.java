package ventas;

public class Producto { // Relación de agregación con Orden, ya que los productos de agregan
    // Se debe empezar a crear las clases que no tengan dependencias
    // Producto es independiente 
    // Es independiente porque sus atributos no tienes relación con otra clase
    // Definir atributos
    private static int contadorProductos; // Valor por defecto es cero (int)
    private final int idProducto; // No se modifica posteriormente
    private String nombre;
    private double precio;

    // Definir métodos
    public Producto(String nombre, double precio) { // Constructor
        this.nombre = nombre;
        this.precio = precio;
        this.idProducto = ++Producto.contadorProductos;
    }

    public int getIdProducto() {
        return this.idProducto; // Atributo de solo lectura
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Info producto: ID: " + this.idProducto + ", Nombre: " + this.nombre + ", Precio: " + this.precio;
    }

}
