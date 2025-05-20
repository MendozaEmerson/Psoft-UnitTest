package org.listparimpar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ParImparTest {

    @Test
    void testTodosPares() {
        List<Integer> entrada = Arrays.asList(2, 4, 6, 8);
        List<String> resultado = ParImpar.evaluarNumeros(entrada);
        assertThat(resultado, contains(
                "2 es par",
                "4 es par",
                "6 es par",
                "8 es par"
        ));
    }

    @Test
    void testTodosImpares() {
        List<Integer> entrada = Arrays.asList(1, 3, 5);
        List<String> resultado = ParImpar.evaluarNumeros(entrada);
        assertThat(resultado, contains(
                "1 es impar",
                "3 es impar",
                "5 es impar"
        ));
    }

    @Test
    void testCeroSolo() {
        List<Integer> entrada = List.of(0);
        List<String> resultado = ParImpar.evaluarNumeros(entrada);
        assertThat(resultado, contains("0 es par"));
    }

    @Test
    void testCeroConOtros() {
        List<Integer> entrada = List.of(0, 1, 2);
        List<String> resultado = ParImpar.evaluarNumeros(entrada);
        assertThat(resultado, contains(
                "0 es par",
                "1 es impar",
                "2 es par"
        ));
    }

    @Test
    void testSoloCeros() {
        List<Integer> entrada = List.of(0, 0, 0);
        List<String> resultado = ParImpar.evaluarNumeros(entrada);
        assertThat(resultado, everyItem(equalTo("0 es par")));
    }

    @Test
    void testNegativosImpares() {
        List<Integer> entrada = List.of(-3, -5);
        List<String> resultado = ParImpar.evaluarNumeros(entrada);
        assertThat(resultado, contains(
                "-3 es impar",
                "-5 es impar"
        ));
    }

    @Test
    void testNegativosPares() {
        List<Integer> entrada = List.of(-2, -4);
        List<String> resultado = ParImpar.evaluarNumeros(entrada);
        assertThat(resultado, contains(
                "-2 es par",
                "-4 es par"
        ));
    }

    @Test
    void testCombinados() {
        List<Integer> entrada = List.of(-1, 0, 2, -4, 3);
        List<String> resultado = ParImpar.evaluarNumeros(entrada);
        assertThat(resultado, contains(
                "-1 es impar",
                "0 es par",
                "2 es par",
                "-4 es par",
                "3 es impar"
        ));
    }

    @Test
    void testListaVacia() {
        List<String> resultado = ParImpar.evaluarNumeros(List.of());
        assertThat(resultado, is(empty()));
    }

    @Test
    void testUnNumero() {
        List<Integer> entrada = List.of(7);
        List<String> resultado = ParImpar.evaluarNumeros(entrada);
        assertThat(resultado, contains("7 es impar"));
    }

    @Test
    void testDiezNumeros() {
        List<Integer> entrada = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<String> resultado = ParImpar.evaluarNumeros(entrada);
        assertThat(resultado, hasSize(10));
        assertThat(resultado.get(0), containsString("impar"));
        assertThat(resultado.get(9), containsString("par"));
    }

    @Test
    void testCienNumeros() {
        List<Integer> entrada = new java.util.ArrayList<>();
        for (int i = 1; i <= 100; i++) entrada.add(i);
        List<String> resultado = ParImpar.evaluarNumeros(entrada);
        assertThat(resultado, hasSize(100));
        assertThat(resultado.get(0), is("1 es impar"));
        assertThat(resultado.get(99), is("100 es par"));
    }

    @Test
    void testAlternanciaParImpar() {
        List<Integer> entrada = List.of(1, 2, 3, 4, 5, 6);
        List<String> resultado = ParImpar.evaluarNumeros(entrada);
        assertThat(resultado, contains(
                "1 es impar",
                "2 es par",
                "3 es impar",
                "4 es par",
                "5 es impar",
                "6 es par"
        ));
    }

    @Test
    void testNumerosRepetidos() {
        List<Integer> entrada = List.of(2, 2, 3, 3);
        List<String> resultado = ParImpar.evaluarNumeros(entrada);
        assertThat(resultado, contains(
                "2 es par",
                "2 es par",
                "3 es impar",
                "3 es impar"
        ));
    }

    @Test
    void testNumerosGrandes() {
        List<Integer> entrada = List.of(1_000_000, -999_999);
        List<String> resultado = ParImpar.evaluarNumeros(entrada);
        assertThat(resultado, contains(
                "1000000 es par",
                "-999999 es impar"
        ));
    }
}
