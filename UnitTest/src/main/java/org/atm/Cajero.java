package org.atm;

import java.util.Scanner;

public class Cajero {
    private double saldo;

    public Cajero(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void consultarSaldo() {
        System.out.println("Su saldo actual es: S/." + saldo);
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Depósito realizado con éxito. Su nuevo saldo es: S/." + saldo);
        } else {
            System.out.println("El monto a depositar debe ser positivo.");
        }
    }

    public void retirar(double monto) {
        if (monto > 0) {
            if (monto <= saldo) {
                saldo -= monto;
                System.out.println("Retiro realizado con éxito. Su nuevo saldo es: S/." + saldo);
            } else {
                System.out.println("Saldo insuficiente.");
            }
        } else {
            System.out.println("El monto a retirar debe ser positivo.");
        }
    }
}

