package com.salesianos.dam;

import com.sun.jdi.connect.Connector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    Calculadora c = new Calculadora();

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    @DisplayName("2 + 2 = 4")
    public void sumarDosNumeros(){
        Calculadora calculadora = new Calculadora();
        assertEquals(4, calculadora.sumar(2,2));
    }

    @Test
    @DisplayName("2 - 2 = 0")
    public void restDosNumeros(){
        Calculadora calculadora = new Calculadora();
        assertEquals(0, calculadora.restar(2,2));
    }

    @Test
    @DisplayName("2 * 2 = 4")
    public void multiplicarDosNumeros(){
        Calculadora calculadora = new Calculadora();
        assertEquals(4, calculadora.multiplicar(2,2));
    }

    @Test
    @DisplayName("2 / 2 = 1")
    public void dividirDosNumeros(){
        Calculadora calculadora = new Calculadora();
        assertEquals(1, calculadora.dividir(2,2));
    }

    @Test
    public void dividirEntre0(){
        Calculadora calculadora = new Calculadora();
        assertThrows(ArithmeticException.class, () -> calculadora.dividir(1,0));
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void dividirEntreCero2(int arguments){
        assertThrows(ArithmeticException.class, () -> {
            c.dividir(arguments, 0);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"Holiwis", "¿Cómo estás?", "Muy bien"})
    public void testComparation(String argument){
        String cadena = "Holis";
        assertNotEquals(argument, cadena);

    }

    @ParameterizedTest
    @MethodSource("intProvider")
    public void sumaMethod(int num, int argument, int resultado){
        assertEquals(resultado, c.sumar(num, argument));
    }

    static Stream<Arguments> intProvider(){
        return Stream.of(
                Arguments.arguments(2,4,6),
                Arguments.arguments(8,10,18)

        );
    }

}
