package aritmetica.prueba;

import aritmetica.Aritmetica;

public class PruebaAritmetica {
    // Un paquete es una colección de archivos y repositorios para organizar las clases

    // Encapsulamiento: Convertir los atributos de la clase a privados

    public static void main(String[] args) {
        // Crear objeto y asignar valores
        var objeto1 = new Aritmetica(5, 5);

        System.out.println(objeto1.getOperador1());
        System.out.println(objeto1.getOperador2());

    } // Fin del método main

}
