public class ForEach {
    public static void main(String[] args) {
        // Ciclo foreach
        // ► Para cada elemento que tengamos en una colección o arreglo

        int[] edades = {38, 50, 69, 13}; // Definir un arreglo

        System.out.println("\n Ciclo tradicional \n");
        for(var i=0; i < edades.length; i++) { // Ciclo tradicional
            System.out.println("edad= " + edades[i]);
        }
        
        System.out.println("\n Ciclo for each \n");
        // Sep puede usar "var" o el tipo de dato que corresponde 
        for(var edad : edades) { // edad guarda los valores del arreglo
            System.out.println("edad= " + edad); // Ya no tenemos acceso a un índice
        } 
    }

}
