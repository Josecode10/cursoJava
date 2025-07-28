import java.io.Serializable;

public class JavaBeans {
    // Estandar para crear objetos sin necesidad de crear más información y que se puedan modificar
    // Debe tener un constructos vacío
    // Atributos deben ser privados (encapsulamiento) y tener los métodos getters y setters
    // Implementar la interface serializeable 
    
    public static void main(String[] args) {

        // Crear un objeto Persona
        var persona = new Persona(); // Usar el constructor vacío

        persona.setNombre("Jose");
        persona.setApellido("Colmenares");

        System.out.println(persona);
        
    }
}

class Persona implements Serializable { // Se debe implementar la clase serializable
    // Debe tener atributos privados
    private String nombre;
    private String apellido;

    // Debe tener un constructor vacio
    public Persona() {}

    // Debe tener los métodos getter y setter
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public String toString() {
        return "Persona {Nombre: " + nombre
                + ", Apellido: " + apellido + "}";
    }

}
