package org.listparimpar;

import java.util.ArrayList;
import java.util.List;

public class ParImpar {
    public static List<String> evaluarNumeros(List<Integer> numeros) {
        List<String> resultados = new ArrayList<>();

        for (int numero : numeros) {
            if (numero % 2 == 0) {
                resultados.add(numero + " es par");
            } else {
                resultados.add(numero + " es impar");
            }
        }

        return resultados;
    }
}
