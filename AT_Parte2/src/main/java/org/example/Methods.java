package org.example;

import javax.swing.*;
import java.awt.*;

import static org.example.Main.*;

public class Methods {
    public static void esperar(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }
    public static void verificarValorResposta(JTextField tf, JFrame janela, JPanel painel) {
        //Checar se tem alguma coisa escrita na caixa de texto
        if (!tf.getText().isEmpty()) {
            if (!codigoCartaostr.equals(tf.getText())) {
                codigoCartaostr = tf.getText();
                //Validar código do cartão
                if (codigoCartaostr.equals(codigoCartaoValido)) {
                    resposta = "ACK";
                } else {
                    resposta = "NACK";
                }
                //Modificar as cores na tela
                if (resposta.equals("ACK")) {
                    System.out.println("ACK");
                    janela.getContentPane().setBackground(Color.green);
                    painel.setBackground(Color.green);
                    esperar(3000);
                    janela.getContentPane().setBackground(Color.decode("#eeeeee"));
                    painel.setBackground(Color.decode("#eeeeee"));
                } else if (resposta.equals("NACK")) {
                    System.out.println("NACK");
                    janela.getContentPane().setBackground(Color.red);
                    painel.setBackground(Color.red);
                    esperar(3000);
                    janela.getContentPane().setBackground(Color.decode("#eeeeee"));
                    painel.setBackground(Color.decode("#eeeeee"));
                } else {
                    System.out.println("Erro: Resposta inválida.");
                }
                //esvaziar caixa de texto
                tf.setText("");
                codigoCartaostr = "";
            }
        } else {
            System.out.println("vazia");
        }
    }
}
