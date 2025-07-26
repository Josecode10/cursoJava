public class Unarios {
    public static void main(String[] args) {

        // Unario -
        int a =  3, b = -2, resultado = 0;

        var c = true;

        resultado = -b;

        System.err.println("Resultado: " + resultado);
        
        // Incremento ++
        a = 3;
        
        resultado = ++a;
        
        System.err.println("Resultado ++a: " + resultado);
        
        a = 3;
        
        resultado = a++;
        
        System.err.println("Resultado a++: " + resultado);

        System.out.println("a = " + a);

    }

}
