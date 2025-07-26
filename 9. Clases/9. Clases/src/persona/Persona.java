package persona;
public class Persona {

    // Convertir los atributos a privados
    // Agregar un constructor público con dos argumentos
    // Utilizar el operador this donde corresponde
    // Agregar los métodos get y set para aplicar el concepto de encapsulamiento
    // Mover la clase persona a un pqt persona
    // Hacer la prueba desde la clase PruebaPersona desde el mismo pqt
    
    // Solo se puede acceder desde los métodos de la clase (private)
    static int contadorPersonas = 0;
    private int idPersona;
    private String nombre;
    private String apellido; 

    // Agregar un constructor que reciba dos argumento
    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.idPersona = ++Persona.contadorPersonas;
    }

    // Constructor vacío
    public Persona() {

    }

    public void mostrarPersona() { // Método para mostrar los atributos del objeto
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Apellido: " + this.apellido);
    }

    @Override
    public String toString() {
        return "Id: " + idPersona + ", Nombre: " + this.nombre + ", Apellido: " + this.apellido;
    }

    public void setNombre(String nombre) { // Método para asignar valor a nombre
        this.nombre = nombre;
    }

    public void setApellido(String apellido) { // Método para asignar valor a apellido
        this.apellido = apellido;
    }

    public String getNombre() { // Método para obtener el valor del atributo nombre
        return this.nombre;
    }

    public String getApellido() { // Método para obtener el valor del atributo apellido
        return this.apellido;
    }

}

