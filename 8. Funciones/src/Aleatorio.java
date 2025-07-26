import java.util.Random;

public class Aleatorio {
    public static void main(String[] args) {
        // Aplicación para generar número aleatorios
        var aleatorio = new Random();

        System.out.println(aleatorio.nextInt(100,200+1));
    }

}
