package org.listparimpar;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int cantidad = VerificationInput.leerEnteroPositivo("¿Cuántos números desea ingresar? ");
        List<Integer> numeros = new ArrayList<>();

        for (int i = 1; i <= cantidad; i++) {
            int numero = VerificationInput.leerEntero("Ingrese el número " + i + ": ");
            numeros.add(numero);
        }

        List<String> resultados = ParImpar.evaluarNumeros(numeros);
        resultados.forEach(System.out::println);
    }
}
