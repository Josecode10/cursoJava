public class ClasesAbstractas {
    public static void main(String[] args) {
        // Son aquellas clases que dejan sin implementar
        // alguno de sus métodos para que las clases
        // hijas o derivadas hagan la implementación

        FiguraGeometrica figuraGeometrica = new Rectangulo();
        figuraGeometrica.dibujar(); // A través de la clase hija se llama el método de la clase abstracta
        
    }
    
}

// No se puede instanciar métodos de clases abstractas
abstract class FiguraGeometrica {
    public abstract void dibujar();
}

class Rectangulo extends FiguraGeometrica {
    @Override
    public void dibujar() {
        System.out.println("Se dibuja un rectángulo...");
    }
    
}