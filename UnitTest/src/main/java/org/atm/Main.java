package org.atm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cajero cajero = new Cajero(1000.0);

        while (true) {
            System.out.println("\n--- Cajero Automático ---");
            System.out.println("1. Consultar Saldo");
            System.out.println("2. Depositar Dinero");
            System.out.println("3. Retirar Dinero");
            System.out.println("4. Salir");

            int opcion = CajeroUtils.leerOpcion(scanner);

            switch (opcion) {
                case 1:
                    cajero.consultarSaldo();
                    break;
                case 2:
                    Double montoDeposito = CajeroUtils.leerMonto(scanner, "depositar");
                    if (montoDeposito != null) {
                        cajero.depositar(montoDeposito);
                    }
                    break;
                case 3:
                    Double montoRetiro = CajeroUtils.leerMonto(scanner, "retirar");
                    if (montoRetiro != null) {
                        cajero.retirar(montoRetiro);
                    }
                    break;
                case 4:
                    System.out.println("Programa Terminado");
                    scanner.close();
                    return;
                default:
                    // Ya manejado en CajeroUtils
            }
        }
    }
}
