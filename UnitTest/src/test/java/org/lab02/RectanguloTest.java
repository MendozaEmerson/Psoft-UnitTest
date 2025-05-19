package org.lab02;

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

//    @Test
//    void testBaseNegativa() {
//        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
//            Rectangulo.calcularArea(-1, 5);
//        });
//        assertEquals("Base y altura deben ser mayores que cero.", exception.getMessage());
//    }
//
//    @Test
//    void testAlturaYBaseNegativa() {
//        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
//            Rectangulo.calcularArea(-3, -6);
//        });
//        assertEquals("Base y altura deben ser mayores que cero.", exception.getMessage());
//    }
}
