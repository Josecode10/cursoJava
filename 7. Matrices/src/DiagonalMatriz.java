public class DiagonalMatriz {
    public static void main(String[] args) {
        System.out.print("--- SUMA DE DIAGOLA ---"); // Imprimir título

        int[][] matriz = {{1,2,3},{4,5,6},{7,8,9}}; // Iniciar y declarar matriz de manera simplificada

        var diagonal = 0;

        for(var i=0; i < matriz.length; i++) {
            for(var j=0; j < matriz[i].length; j++) {
                if (i == j) {
                    diagonal += matriz[i][j];
                }
            }
        }

        System.out.print("\nSuma de los elementos de la diagonal = " + diagonal + "\n");

    }

}
