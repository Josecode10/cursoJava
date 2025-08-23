package zona_fit.dominio;

// Por buenas prácticas si tenemos una tabla en la bd
// vamos a crear una clase en java que la represente
// java --- atributos
// Database --- columnas 
public class Cliente {
    private int id;
    private String nombre;
    private String apellido;
    private int membresia;

    // Constructor por defecto
    // Se usa para crear un objeto cliente sin asignar valores a los atributos
    public Cliente() {}

    public Cliente(int id) {
        this.id = id;
    }

    // Constructor que recibe los parámetros nombre, apellido y membresia
    // Se usa para crear un objeto cliente con los valores de nombre, apellido y membresia
    public Cliente(String nombre, String apellido, int membresia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.membresia = membresia;
    }

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

    public String getApellido() {
        return apellido;
    }
    
    public int getMembresia() {
        return membresia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
        
    public void setApellido(String apellido) {
        this.apellido = apellido;
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
