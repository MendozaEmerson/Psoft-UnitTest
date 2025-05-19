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
        assertThat(Rectangulo.calcularArea(12, 5.6), is(67.2));
        assertThat(Rectangulo.calcularArea(24.9, 19), is(473.1));
        assertThat(Rectangulo.calcularArea(120.9, 234.2), is(28314.78));
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
//    void testAlturaCero() {
//        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
//            Rectangulo.calcularArea(5, 0);
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
