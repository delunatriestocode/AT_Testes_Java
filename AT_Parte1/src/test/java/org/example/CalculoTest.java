package org.example;

import org.junit.jupiter.api.Test;
import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculoTest {

    @Test
    void botaoSoma() {
        String resultado, esperado;
        JTextField TF11 = new JTextField("1");
        JTextField TF21 = new JTextField("2");
        JTextField TF12 = new JTextField("4");
        JTextField TF22 = new JTextField("5");

        Complexo complexo = new Complexo();
        resultado = complexo.botaoSoma(TF11, TF21, TF12, TF22);
        esperado = "Resultado: 5 + 7i";
        assertEquals(esperado, resultado);
    }

    @Test
    void botaoSub() {
        String resultado, esperado;
        JTextField TF11 = new JTextField("1");
        JTextField TF21 = new JTextField("2");
        JTextField TF12 = new JTextField("4");
        JTextField TF22 = new JTextField("5");

        Complexo complexo = new Complexo();
        resultado = complexo.botaoSub(TF11, TF21, TF12, TF22);
        esperado = "Resultado: -3 - -3i";
        assertEquals(esperado, resultado);
    }

    @Test
    void botaoMod() {
        String resultado, esperado;
        JTextField TF11 = new JTextField("1");
        JTextField TF21 = new JTextField("2");
        JTextField TF12 = new JTextField("4");
        JTextField TF22 = new JTextField("5");

        Complexo complexo = new Complexo();
        resultado = complexo.botaoMod(TF11, TF21, TF12, TF22);
        esperado = "Resultado: |z1| = √5 // |z2| = √41";
        assertEquals(esperado, resultado);
    }
}