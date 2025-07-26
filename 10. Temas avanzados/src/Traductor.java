import javax.annotation.processing.SupportedSourceVersion;

// Estandarizar el comportamiento de nuestro código
public interface Traductor {
    // By default si no especificamos otra cosa son públicos y estáticos
    void traducir();

    // Métodos con implementación by default
    default void iniciarTraductor() {
        System.out.println("Iniciando traductor...");
    }

}

class Ingles implements Traductor {
    @Override
    public void traducir() {
        System.out.println("Traduzco a ingles ...");
    }
}

class PruebaTraductor {
    public static void main(String[] args) {
        Traductor ingles = new Ingles();
        ingles.iniciarTraductor();

    }
}