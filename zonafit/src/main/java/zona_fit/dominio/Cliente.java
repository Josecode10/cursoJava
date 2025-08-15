package zona_fit.dominio;

public class Cliente {
    private int id;
    private String nombre;
    private String apellido;
    private int membresia;

    public Cliente() {}

    // Datos se pueden eliminar solo por ID, por eso este constructor
    public Cliente(int id) {
        this.id = id;
    }

    // Constructor
    public Cliente(String nombre, String apellido, int membresia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.membresia = membresia;
    }

    // Constructor con todos los parámetros
    // Recuperar los objetos de tipo cliente --- objetos ya creados llamados de la bd
    public Cliente(int id, String nombre, String apellido, int membresia) {
        this(nombre, apellido, membresia);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getMembresia() {
        return membresia;
    }

    public void setMembresia(int membresia) {
        this.membresia = membresia;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id +
                ", nombre=" + nombre + 
                ", apellido=" + apellido + 
                ", membresia=" + membresia + 
                "]";
    }

    // Los metodos equals y hashcode sirven para agilizar la búsqueda el ordenamiento
    // o cualquier operación que hagamos sobre una lista de objetos de tipo cliente

    // Genera un valor de tipo entero que representa un valor numérico
    // para cada uno de los objetos de tipo cliente
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
        result = prime * result + membresia;
        return result;
    }

    // Compara el contenido de dos objetos de tipo cliente
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (id != other.id)
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (apellido == null) {
            if (other.apellido != null)
                return false;
        } else if (!apellido.equals(other.apellido))
            return false;
        if (membresia != other.membresia)
            return false;
        return true;
    }

    

}
