public class Recursiva {
    // Funcion recursiva
    static void funcionRecursiva(int a) { // Una vez se inicia esta función se llama a si misma y no llega a salir
        if(a == 1) { // Caso base
            System.out.println("Numero = " + a);
        } else { // Caso recursivo
            System.out.println("Numero = " + a);
            funcionRecursiva(a - 1);
        }
        
    } // Fin de la función

    public static void main(String[] args) {
        // Funciones que se llaman a sí mismas 

        funcionRecursiva(5); // Llamar la función recursiva

    } // Fin del método main
}
