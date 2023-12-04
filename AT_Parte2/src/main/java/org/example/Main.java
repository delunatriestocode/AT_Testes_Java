package org.example;


import javax.swing.*;
import java.awt.*;

import static org.example.Methods.*;

public class Main {
    static String resposta = "";
    static String codigoCartaostr = "";
    static String codigoCartaoValido = "12345678";
    public static void main(String[] args) {
        JFrame janela = new JFrame("Exercício 2");
        janela.setSize(500,150);
        janela.setResizable(false);

        JPanel painel = new JPanel();

        //Painel pro input do usuário
        JLabel codCartaoLabel = new JLabel("Código do cartão: ");
        codCartaoLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        JTextField tf = new JTextField(20);

        //Painel principal
        painel.add(codCartaoLabel);
        painel.add(tf);
        janela.add(painel);

        janela.setLocationRelativeTo(null);
        janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        janela.setLayout(new FlowLayout());
        janela.setVisible(true);

        //Verificação ciclica do valor da resposta
        while (true) {
            verificarValorResposta(tf, janela, painel);
        }
    }

}