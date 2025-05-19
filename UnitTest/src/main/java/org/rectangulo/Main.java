package org.rectangulo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la base y la altura del rectángulo:");

        System.out.print("Base: ");
        String baseInput = scanner.nextLine();

        System.out.print("Altura: ");
        String alturaInput = scanner.nextLine();

        if (!Utilidades.esNumero(baseInput) || !Utilidades.esNumero(alturaInput)) {
            System.out.println("Error: Por favor, ingrese solo números válidos.");
            return;
        }

        double base = Double.parseDouble(baseInput);
        double altura = Double.parseDouble(alturaInput);

        try {
            double area = Rectangulo.calcularArea(base, altura);
            System.out.printf("El área del rectángulo con base %.2f y altura %.2f es: %.2f%n", base, altura, area);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
