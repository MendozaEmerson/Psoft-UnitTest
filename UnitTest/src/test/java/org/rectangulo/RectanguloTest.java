package org.rectangulo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class RectanguloTest {

    @DisplayName("Base y Altura en una " +
            "combinación de enteros y decimales positivos")
    @Test
    void testCalculoCorrecto() {
        assertThat(Rectangulo.calcularArea(4, 2), is(8.0));
        assertThat(Rectangulo.calcularArea(12, 5.6), closeTo(67.2,0.01));
        assertThat(Rectangulo.calcularArea(24.9, 19), closeTo(473.1,0.01));
        assertThat(Rectangulo.calcularArea(120.9, 234.2), is(28314.78));
    }

    @DisplayName("Altura con valor de cero y base entera positiva")
    @Test
    void testAlturaCero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Rectangulo.calcularArea(45, 0);
        });
        assertThat(exception.getMessage(), is("Base y altura deben ser mayores que cero."));
    }

    @DisplayName("Base con valor de cero y altura decimal positiva")
    @Test
    void testBaseCero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Rectangulo.calcularArea(0, 23.9);
        });
        assertThat(exception.getMessage(), is("Base y altura deben ser mayores que cero."));
    }

    @DisplayName("Base y altura con valores cero")
    @Test
    void testBaseAlturaCero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Rectangulo.calcularArea(0, 0);
        });
        assertThat(exception.getMessage(), is("Base y altura deben ser mayores que cero."));
    }

    @DisplayName("Base con valor entero negativo y altura decimal positivo")
    @Test
    void testBaseNegativa1() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Rectangulo.calcularArea(-10, 21.8);
        });
        assertThat(exception.getMessage(), is("Base y altura deben ser mayores que cero."));
    }

    @DisplayName("Base con valor entero negativo y altura entero positivo")
    @Test
    void testBaseNegativa2() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Rectangulo.calcularArea(-14, 58);
        });
        assertThat(exception.getMessage(), is("Base y altura deben ser mayores que cero."));
    }

    @DisplayName("Base con valor decimal negativo y altura decimal positivo")
    @Test
    void testBaseNegativa3() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Rectangulo.calcularArea(-67.9, 50.8);
        });
        assertThat(exception.getMessage(), is("Base y altura deben ser mayores que cero."));
    }

    @DisplayName("Base con valor decimal negativo y altura entero positivo")
    @Test
    void testBaseNegativa4() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Rectangulo.calcularArea(-43.1, 90);
        });
        assertThat(exception.getMessage(), is("Base y altura deben ser mayores que cero."));
    }

    @DisplayName("Altura con valor decimal negativo y base entero positivo")
    @Test
    void testAlturaNegativa1() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Rectangulo.calcularArea(31, -6.89);
        });
        assertThat(exception.getMessage(), is("Base y altura deben ser mayores que cero."));
    }

    @DisplayName("Altura con valor decimal negativo y base decimal positivo")
    @Test
    void testAlturaNegativa2() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Rectangulo.calcularArea(87.1, -69.89);
        });
        assertThat(exception.getMessage(), is("Base y altura deben ser mayores que cero."));
    }

    @DisplayName("Altura con valor entero negativo y base entero positivo")
    @Test
    void testAlturaNegativa3() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Rectangulo.calcularArea(113, -71);
        });
        assertThat(exception.getMessage(), is("Base y altura deben ser mayores que cero."));
    }

    @DisplayName("Altura con valor entero negativo y base decimal positivo")
    @Test
    void testAlturaNegativa4() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Rectangulo.calcularArea(93.9, -101);
        });
        assertThat(exception.getMessage(), is("Base y altura deben ser mayores que cero."));
    }

    @DisplayName("Altura y base enteros negativos")
    @Test
    void testBaseAlturaNegativa1() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Rectangulo.calcularArea(-77, -89);
        });
        assertThat(exception.getMessage(), is("Base y altura deben ser mayores que cero."));
    }

    @DisplayName("Altura y base decimales negativos")
    @Test
    void testBaseAlturaNegativa2() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Rectangulo.calcularArea(-31.31, -89.73);
        });
        assertThat(exception.getMessage(), is("Base y altura deben ser mayores que cero."));
    }

    @DisplayName("Entradas numericas válidas (enteros y decimales)")
    @Test
    void testEntradaNumericaValida() {
        assertThat(Utilidades.esNumero("12.45"), is(true));
        assertThat(Utilidades.esNumero("56"), is(true));
    }

    @DisplayName("Entradas no numericas válidas como:" +
            "letras, espacios, errores de tipeo y simbolos")
    @Test
    void testEntradaNoNumerica() {
        assertThat(Utilidades.esNumero("abc"), is(false));
        assertThat(Utilidades.esNumero("5,5"), is(false));
        assertThat(Utilidades.esNumero("1001aLÑ3"), is(false));
        assertThat(Utilidades.esNumero(" "), is(false));
        assertThat(Utilidades.esNumero("@!#$"), is(false));
    }

}
