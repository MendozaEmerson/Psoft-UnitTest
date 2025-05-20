package org.atm;

import java.util.Scanner;

public class CajeroUtils {

    public static int leerOpcion(Scanner scanner) {
        System.out.print("Seleccione una opción (1-4): ");
        String input = scanner.nextLine();

        try {
            int opcion = Integer.parseInt(input);
            if (opcion >= 1 && opcion <= 4) {
                return opcion;
            } else {
                System.out.println("Opción inválida. Por favor, seleccione una opción del 1 al 4.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Opción inválida. Por favor, seleccione una opción del 1 al 4.");
        }

        return -1;
    }

    public static Double leerMonto(Scanner scanner, String tipoOperacion) {
        System.out.print("Ingrese la cantidad a " + tipoOperacion + ": ");
        String input = scanner.nextLine();
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un valor numérico válido.");
            return null;
        }
    }
}

