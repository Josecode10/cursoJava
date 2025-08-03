import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Introducir valores a una matriz de manera dinámica
        
        var consola = new Scanner(System.in); // Crear el objeto consola para llamar los métodos de la clase escaner

        System.out.print("Cuántas filas tiene la matriz: "); // Solicitar cantidad filas
        int rows = Integer.parseInt(consola.nextLine()); // Capturas valor ingresado
        System.out.print("Cuántas conlumnas tiene la matriz: "); // Solicitar cantidad de columnas
        int conlumns = Integer.parseInt(consola.nextLine()); // Capurar el valor ingresado

        int[][] matriz = new int[rows][conlumns]; // Incializar y declarar el objeto matriz

        // Crear matriz con valores ingresado por teclado
        for(var i=0; i < matriz.length; i++) { // Hacer ciclos por las filas
            for(var j=0; j < matriz[i].length; j++) { // Hacer ciclos por las columnas 
                System.out.print("Ingresar elemento de la fila "+ i +", columna "+ j +": "); // Solicitar valor según columna y fila
                matriz[i][j] = Integer.parseInt(consola.nextLine()); // Capturar el valor ingresado
            }
        }

        System.out.println("\n-------- Imprimir matriz ----------\n");

        // Imprimir matriz
        for(var i=0; i < matriz.length; i++) {
            for(var j=0; j < matriz[i].length; j++) {
                System.out.println("Matriz[" + i + "][" + j + "] = " + matriz[i][j]);
            }
        }

        // // Forma simplificada de iniciar y declar una matriz
        // int[][] matriz = {{100,200,300},{400,500,600}};

        // // Imprimir matriz
        // System.out.print("{");
        // for(var i=0; i < matriz.length; i++) {
        //     for(var j=0; j < matriz[i].length; j++) {
        //         System.out.print(matriz[i][j]);
        //         if (j < 2) {
        //             System.out.print(", ");
        //         }
        //     }
        //     if (i==1) {
        //         System.out.print("}");
        //     } else {
        //         System.out.println("");
        //     }
        // }
                 
    }
    
}