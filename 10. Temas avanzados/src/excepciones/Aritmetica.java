package excepciones;

public class Aritmetica {
    public static int division(int numerado, int denominador) throws Exception {
        if (denominador == 0) {
            throw new Exception("División entre cero");
        }
        return numerado / denominador;
    }

}
