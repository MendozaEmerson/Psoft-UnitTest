package org.atm;

import org.junit.jupiter.api.*;
import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class CajeroTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private PrintStream originalOut;
    private InputStream originalIn;
    private Cajero cajero;

    @BeforeEach
    public void setUp() {
        originalOut = System.out;
        originalIn = System.in;
        System.setOut(new PrintStream(output));
        cajero = new Cajero(1000.0);
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    // ---------- Test de opciones de menú ----------

    @Test
    public void testOpcionVacia() {
        setInput("  ");
        CajeroUtils.leerOpcion(new Scanner(System.in));
        assertTrue(output.toString().contains("Opción inválida"));
    }

    @Test
    public void testOpcionInvalidaNumero() {
        setInput("10");
        CajeroUtils.leerOpcion(new Scanner(System.in));
        assertTrue(output.toString().contains("Opción inválida"));
    }

    @Test
    public void testOpcionLetra() {
        setInput("a");
        CajeroUtils.leerOpcion(new Scanner(System.in));
        assertTrue(output.toString().contains("Opción inválida"));
    }

    @Test
    public void testOpcionSimbolo() {
        setInput("#");
        CajeroUtils.leerOpcion(new Scanner(System.in));
        assertTrue(output.toString().contains("Opción inválida"));
    }

    @Test
    public void testConsultarSaldo() {
        cajero.consultarSaldo();
        assertTrue(output.toString().contains("Su saldo actual es: S/.1000.0"));
    }

    @Test
    public void testDepositoNegativo() {
        cajero.depositar(-100);
        assertTrue(output.toString().contains("El monto a depositar debe ser positivo."));
    }

    @Test
    public void testDepositoDecimalPositivo() {
        cajero.depositar(50.5);
        assertTrue(output.toString().contains("Depósito realizado con éxito"));
        assertTrue(output.toString().contains("S/.1050.5"));
    }

    @Test
    public void testDepositoDecimalNegativo() {
        cajero.depositar(-50.5);
        assertTrue(output.toString().contains("El monto a depositar debe ser positivo."));
    }

    @Test
    public void testDepositoEnteroPositivo() {
        cajero.depositar(100);
        assertTrue(output.toString().contains("S/.1100.0"));
    }

    @Test
    public void testDepositoLetra() {
        setInput("x");
        CajeroUtils.leerMonto(new Scanner(System.in), "depositar");
        assertTrue(output.toString().contains("Ingrese un valor numérico válido."));
    }

    @Test
    public void testDepositoSimbolo() {
        setInput("%");
        CajeroUtils.leerMonto(new Scanner(System.in), "depositar");
        assertTrue(output.toString().contains("Ingrese un valor numérico válido."));
    }

    @Test
    public void testDepositoCero() {
        cajero.depositar(0);
        assertTrue(output.toString().contains("El monto a depositar debe ser positivo."));
    }

    @Test
    public void testRetiroNegativoEntero() {
        cajero.retirar(-120);
        assertTrue(output.toString().contains("El monto a retirar debe ser positivo."));
    }

    @Test
    public void testRetiroDecimalPositivo() {
        cajero.retirar(58.5);
        assertTrue(output.toString().contains("Retiro realizado con éxito"));
        assertTrue(output.toString().contains("S/.941.5"));
    }

    @Test
    public void testRetiroDecimalNegativo() {
        cajero.retirar(-20.5);
        assertTrue(output.toString().contains("El monto a retirar debe ser positivo."));
    }

    @Test
    public void testRetiroEnteroPositivo() {
        cajero.retirar(100);
        assertTrue(output.toString().contains("S/.900.0"));
    }

    @Test
    public void testRetiroLetra() {
        setInput("a");
        CajeroUtils.leerMonto(new Scanner(System.in), "retirar");
        assertTrue(output.toString().contains("Ingrese un valor numérico válido."));
    }

    @Test
    public void testRetiroSimbolo() {
        setInput("!");
        CajeroUtils.leerMonto(new Scanner(System.in), "retirar");
        assertTrue(output.toString().contains("Ingrese un valor numérico válido."));
    }

    @Test
    public void testRetiroCero() {
        cajero.retirar(0);
        assertTrue(output.toString().contains("El monto a retirar debe ser positivo."));
    }

    @Test
    public void testRetiroMasDelSaldo() {
        cajero.retirar(5000);
        assertTrue(output.toString().contains("Saldo insuficiente."));
    }

    // ---------- Utilidad para simular entrada ----------
    private void setInput(String data) {

        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }
}
