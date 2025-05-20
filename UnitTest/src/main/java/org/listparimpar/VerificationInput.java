package org.listparimpar;

import java.util.Scanner;

public class VerificationInput {
    private static final Scanner scanner = new Scanner(System.in);

    // Lee cualquier entero
    public static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
            }
        }
    }

    // Lee solo enteros positivos (puede incluir 0 o excluirlo, según prefieras)
    public static int leerEnteroPositivo(String mensaje) {
        int valor;
        do {
            valor = leerEntero(mensaje);
            if (valor < 0) {
                System.out.println("Por favor ingrese un número entero positivo.");
            }
        } while (valor < 0);
        return valor;
    }
}
