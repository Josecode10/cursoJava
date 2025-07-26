package persona; // Por buenas prácticas el nombre del pqt se escribe con minúscula

public class PruebaPersona {
    public static void main(String[] args) {

        System.out.println("--- Creación de objetos de la clase persona ---"); // Imprimir titulo
        System.out.println("Contador personas: " + Persona.contadorPersonas);
        var objeto1 = new Persona("Manuel", "Colmenares"); // Crear objeto de la clase persona
        
        System.out.println(objeto1); // Imprimir el objeto1 (Por defecto ya esta el método agregado)
        
        System.out.println("Contador personas: " + Persona.contadorPersonas);
        
        var objeto2 = new Persona("Jessica", "Mendoza");

        System.out.println(objeto2);
        
        System.out.println("Contador personas: " + Persona.contadorPersonas);

        // System.out.println("Primera asignación: ");
        // // Crear el objeto persona y pasar argumentos
        // var persona1 = new Persona("Manuel", "Colmenares");
        
        // // Usar los métodos de la clase persona a través del objeto
        // System.out.println("\nNombre: " + persona1.getNombre() + "\nApellido: " + persona1.getApellido() + "\n");
        
        // System.out.println("Segunda asignación: ");
        // // Usar método para cambiar nombre y apellido
        // persona1.setNombre("Jessica");
        // persona1.setApellido("Mendoza");
        
        // // Usar los métodos de la clase persona a través del objeto
        // System.out.println("\nNombre: " + persona1.getNombre() + "\nApellido: " + persona1.getApellido() + "\n");

        // // Método mostrar persona
        // persona1.mostrarPersona();

    }
}
