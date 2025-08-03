package Animales;

// Clase principal (la única que puede ser pública)
public class Animal {
    // Definir atributos


    // Definir métodos
    public void hacerSonido() {
        System.out.println("El animal hace un sonido");
    }

} // Fin de la clase Animal

// Clase perro
class Perro extends Animal { // La palabra reservada "extend" permite crear clases hijas
    // Definir atributos

    // Definir métodos
    public void hacerSonido() {
        System.out.println("El perro hace uau");
    }

} // Fin de la clase perro

// Clase gato
class Gato extends Animal {
    // Definir atributos

    // Definir métodos
    public void hacerSonido() {
        System.out.println("El gato hace miau");
    }


} // Fin de la clase gato



// Definir clase para realizar prueba
class PruebaAnimal {
    public static void main(String[] args) {
        // Ejemplo de polimorfismo
        System.out.println("\n--- Polimorfismo ---\n"); // Titulo

        System.out.println("\nObjeto de la clase animal\n");

        // var animal = new Animal(); // Crear objeto de la clase animal

        // Los objeto de las subclases se pueden crear como ojetos de la superclase
        Animal animal = new Gato(); // Polimorfimos
        animal.hacerSonido(); // Llamar el método de la clase animal

        // // "super" palabra reservada para acceder a la funcionalidad original del método sobreescrito
        // System.out.println("--- Herencia ---");
        // System.out.println("Clase padre, soy un Animal");
        // var animal1 = new Animal(); // Crear objeto de la clase animal
        // animal1.comer();
        // animal1.dormir(); // No se puede acceder desde Animal

        // System.out.println("Soy un perrro: ");
        // var perro1 = new Perro(); // Crear objeto de la clase perro
        // perro1.hacerSonido(); // Llamar método de la clase perro
        // perro1.comer(); // Llamar un método heredado de la clase padre (Animal)
        // perro1.dormir(); // Llamar método sobreescrito de la clase padre
        
    }
}

