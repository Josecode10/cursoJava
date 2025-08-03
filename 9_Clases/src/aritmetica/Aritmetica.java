package aritmetica;
public class Aritmetica {
    // Encapsulamiento: Convertir los atributos de la clase a privados
    private int operando1; // Por propiedad de encapsulamiento se agrega la palabra reservada "private"
    private int operando2; // Por propiedad de encapsulamiento se agrega la palabra reservada "private"

    public Aritmetica(int operando1, int operando2) { // Método constructor
        this.operando1 = operando1;
        this.operando2 = operando2;
    }

    public Aritmetica() { // Sobrecarga de constructores -- Constructor vacio

    }

     public void sumar() {
        var resultado = operando1 + operando2;
        System.out.println("Resultado de la suma: " + resultado);
    }

    public void restar() {
        var resultado = operando1 - operando2;
        System.out.println("Resultado de la resta: " + resultado);
    }

    public void setOperador1(int operando1) { // Método para asignar un valor al operando1
        this.operando1 = operando1;
    }

    public void setOperador2(int operando2) { // Método para asignar un valor al operando2
        this.operando2 = operando2;
    }

    public int getOperador1() { // Método para mostrar el valor del operando1
        return this.operando1;
    }

    public int getOperador2() {
        return this.operando2;
    }

}
