package maquina_snacks_archivos.dominio;

import java.io.Serializable;

public class Snack implements Serializable { // Javabean
    // Atributos
    private static int contadorSnacks;
    private int snackId;
    private String nombre;
    private double precio;

    // Para que sea un javabean debe tener un constructor vacío
    // NO recibe parámetros
    public Snack() { 
        this.snackId = ++Snack.contadorSnacks;

    }

    // Podemos tener más de un constructor
    public Snack(String nombre, double precio) {
        this(); // Llamada al constructor vacío de manera interna
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getSnackId() {
        return snackId;
    }

    @Override
    public String toString() {
        return "Snack [snackId=" + snackId + ", nombre=" + nombre + ", precio=" + precio + "]";
    }

    public String escribirSnack() {
        return snackId + "," + nombre + "," + precio;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + snackId;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        long temp;
        temp = Double.doubleToLongBits(precio);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Snack other = (Snack) obj;
        if (snackId != other.snackId)
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (Double.doubleToLongBits(precio) != Double.doubleToLongBits(other.precio))
            return false;
        return true;
    }

}
