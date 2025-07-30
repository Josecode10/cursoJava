package varios;
public class ArgumentosVariables {
    public static void main(String[] args) {
        // --- Argumentos variables ----
        // Para hacer más flexible el paso de información a nuestros métodos
        // Consiste en pasar múltiples parámetros a una misma función
        System.out.println("\n--- Método imprimir números ---\n");
        imprimirNumeros(1, 2, 3, 4, 5); // var args = varargs

        System.out.println("\n--- Método varios parámetros ---\n");
        variosParametros("Jessica", 6, 7, 8, 9, 10);

    }

    // Se pones 3 puntos después del tipo de dato para indicar que recibe múltiples parámetros
    // Se crea un arreglo en memoria
    static void imprimirNumeros(int... numeros) { 
        for(var i=0; i< numeros.length; i++) {
            System.out.println(numeros[i]);
        }
    }
    // Diferentes tipos de datos
    static void variosParametros(String nombre, int... numeros) {
        System.out.println("Nombre: " + nombre);
        imprimirNumeros(numeros); // Utilizamos el método definido anteriormente
    }

}
