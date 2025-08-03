import java.util.Scanner;

public class CajeroAutomatico {
    public static void main(String[] args) {
        // Imprimir título del programa
        System.out.println("*** Aplicción Cajero Automático ***");

        // Funciones principales: depositar, retirar y consultar saldo de una cuenta X

        // Inicializar y crear la variable de saldo inicial
        var saldoInicial = 1000;

        // Iniciar y declara variable que determina si el ciclo continua
        var continuar = true;

        while (continuar) {
            // Mostrar menú
            System.out.print("""
                Menú:
                1. Consultar saldo
                    2. Retirar
                    3. Depositar
                    4. Salir
                    Escoge una opción:\s
                    """);
            
            var seleccion = Integer.parseInt((new Scanner(System.in)).nextLine());
            
            switch (seleccion) {
                case 1 -> System.out.println("Saldo es igual a " + saldoInicial); // Consultar saldo
                case 2 -> { // Retirar dinero
                    System.out.print("Ingresar el valor a retirar: ");
                    var retiro = Integer.parseInt(new Scanner(System.in).nextLine());
                    
                    // Validad saldo para determinar si se puede realizar el retiro
                    if (retiro <= saldoInicial) {
                        saldoInicial -= retiro;
                        System.out.println("¡Retiro exitoso!\nSaldo actual = " + saldoInicial);
                    }
                    else {
                        System.out.println("¡Saldo insuficiente!");
                    }
                }
                case 3 -> { // Depositar dinero
                    System.out.print("Ingresar el valor a depositar: ");
                    var deposito = Integer.parseInt(new Scanner(System.in).nextLine());
                    saldoInicial += deposito;
                    System.out.println("¡Depósito exitoso!\nSaldo actual = " + saldoInicial);
                } 
                case 4 -> { // Salir del sistema
                    System.out.println("¡Has salido del sistema!");
                    continuar = false;
                }
                default -> System.out.println("¡Valor inválido!");
            }
            System.out.println();
        }
        
    }

}
