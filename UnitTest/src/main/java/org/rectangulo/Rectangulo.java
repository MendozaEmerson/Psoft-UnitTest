package org.rectangulo;

public class Rectangulo {

    public static double calcularArea(double base, double altura) {
        if (base <= 0 || altura <= 0) {
            throw new IllegalArgumentException("Base y altura deben ser mayores que cero.");
        }
        return base * altura;
    }
}
