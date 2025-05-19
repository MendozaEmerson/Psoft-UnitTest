package org.lab02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese la base y la altura del rectángulo:");

            System.out.print("Base: ");
            double base = Double.parseDouble(scanner.nextLine());

            System.out.print("Altura: ");
            double altura = Double.parseDouble(scanner.nextLine());

            double area = Rectangulo.calcularArea(base, altura);
            System.out.printf("El área del rectángulo con base %.2f y altura %.2f es: %.2f%n", base, altura, area);
        } catch (NumberFormatException e) {
            System.out.println("Error: Por favor, ingrese solo números válidos.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
