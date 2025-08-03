import java.text.DecimalFormat;

public class Redondeo {
    public static void main(String[] args) { 
        // APLICAR FORMATO A NUMEROS CON DECIMALES
        var a = 56.7378;
        var patron = "#.##";

        var decimalFormat = new DecimalFormat(patron);
        var aFormateado = decimalFormat.format(a);

        System.out.println("\nNúmero original = " + a + "\nNúmero con formato = " + aFormateado + "\n");
        
        // Aplicación para redondear número
        // var a = 7.4; // Iniciar y declarar número a redondear
        // var b = 8.6; // Iniciar y declarar número a redondear

        // var redondeado = Math.round(a); // Aplicar el método round de la clase Math

        // System.out.println("a = " + redondeado);

    }

}
