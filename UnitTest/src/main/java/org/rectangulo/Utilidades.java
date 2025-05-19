package org.rectangulo;

public class Utilidades {
    public static boolean esNumero(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
