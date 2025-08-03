package varios;
public class Excepciones {
    public static void main(String[] args) {
        // Excepciones en JAVA
        // División entre cero

        try { // Bloque para procesar posibles errores
            int num1 = 10, num2 = 0; // Definir variables
            var resultado = num1 / num2;
            // La siguiente operación va a arrojar una excepción en tiempo de ejecución
            // El ID no va a arrojar ningún al momento de compilación
            System.out.println("Resultado: " + resultado);
        } catch(Exception e) {
            System.out.println("Ocurrió un error: " + e);
        }
        
    }

}
