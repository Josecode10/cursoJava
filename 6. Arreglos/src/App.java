import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Crear un arreglo de manera dinámica
        System.out.print("Cuántos elementos desea ingresar:\s"); // Usuario define el "length" del arreglo
        var largo = Integer.parseInt(new Scanner(System.in).nextLine()); // Capturar el valor ingresado por el usuario

        String[] peliculas = new String[largo]; // Inicializar y declarar el arreglo en una sola línea

        for(var i=0; i < peliculas.length; i++) { // Realizar ciclos para crear el arreglo
            System.out.print("\nIngresar película\s"+ (i+1) +":\s"); // Solicitar película al usuario
            peliculas[i] = new Scanner(System.in).nextLine(); // Capturar información
        }
        System.out.println("\n*** Lista de películas ***\n"); // Imprimir título
        for(var i=0; i < peliculas.length; i++) { // Realizar ciclos para imprimir los elementos del arreglo
            System.out.println((i+1) + ")\s" + peliculas[i]); // Imprimir películas
        }

        // // Ingresar valores de manera dinámica a un arreglo
        // String[] informacionPersonal = new String[3];

        // for(var i = 0; i < informacionPersonal.length; i++) {
        //     if (i==0) {
        //         System.out.print("Ingresar nombres: ");
        //         informacionPersonal[i] = new Scanner(System.in).nextLine();
        //     }
        //     else if (i==1) {
        //         System.out.print("Ingresar apellidos: ");
        //         informacionPersonal[i] = new Scanner(System.in).nextLine();
        //     }
        //     else {
        //         System.out.print("Ingresar ID: ");
        //         informacionPersonal[i] = new Scanner(System.in).nextLine();
        //     }
        // }

        // System.out.println("");
        // System.out.print("{");
        // for(var j = 0; j < informacionPersonal.length; j++) {
        //     System.out.print(informacionPersonal[j]);
        //     if (j < informacionPersonal.length-1) {
        //         System.out.print(" | ");
        //     }            
        // }
        // System.out.print("}");
        
        // ¡Crear un arreglo en Java!

        // int[] enteros; // Declarar un arreglo
        // enteros = new int[5]; // Inicializar un arreglo

        // int[] numeros = new int[3]; // Declarar e inicializar un arreglo en una misma línea

        // enteros[0] = 23;
        // enteros[1] = 24;
        // enteros[3] = 26;
        // enteros[4] = 27;


        // numeros[0] = 1;
        // numeros[1] = 2;
        // numeros[2] = 3;

        // // Imprimir los valores de un arreglo

        // System.out.println(enteros[0]);
        // System.out.println(enteros[2]);
        // System.out.println(numeros[0]);

        // // Inicializacion simplificada de un arreglo

        // String[] vocales = {"a", "b", "c", "d", "e"};
        // double[] calificaciones = {5, 3.4, 4,8};

        // System.out.println(vocales[0] +" "+ vocales[4] +" "+calificaciones[0]);

        // System.out.println("----------------------");
        // System.out.print("{");
        // for(var i = 0; i < vocales.length; i++) { // Imprimir los elementos de un arreglo usando el ciclo "for"
        // System.out.print(vocales[i]);
        // if (i < vocales.length-1) {
        //     System.out.print(",");
        // }
        // }
        // System.out.println("}");
    
        // System.out.println("----------------------"); 
        // char[] caracteres = {'A', 'B', 'C', 'E', 'F', 'G'}; // Forma simplificada de declarar e inicializar un arreglo
        // System.out.print("{");
        // for(var j=0; j < caracteres.length; j++){ // Imprimir los elementos de un arreglo
        //     System.out.print(caracteres[j]);
        //     if (j < caracteres.length-1) {
        //         System.out.print(",");
        //     }
        // }
        // System.out.print("}");
    }
}
