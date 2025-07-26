public class Logicos {
    public static void main(String[] args) {
        boolean a = true, b = false;

        var resultado = a && b;

        System.out.println("Resultado a && b = " + resultado);

        resultado = a || b;

        System.out.println("Resultado a or b = " + resultado);

        resultado = a && !b;

        System.out.println("Resultado a && !b = " + resultado);
        

        
    }
}
