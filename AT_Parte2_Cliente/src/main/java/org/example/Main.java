package org.example;


import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.example.Methods.*;

public class Main {
    static String resposta = "";
    static String codigoCartaostr = "";
    static String codigoCartaoValido = "12345678";
    public static void main(String[] args) {
        JFrame janelaCliente = new JFrame("Exercício 2 (Cliente)");
        janelaCliente.setSize(300,150);
        janelaCliente.setResizable(false);

        JPanel painel = new JPanel(new GridLayout(2,2));

        //Inputs Usuário
        JLabel codCartaoLabel = new JLabel("Código:");
        codCartaoLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        JTextField tf_codigo = new JTextField(20);
        JLabel respostaLabel = new JLabel("Resposta:");
        respostaLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        JTextField tf_resposta = new JTextField(20);

        tf_codigo.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                verificarValorResposta(tf_codigo, tf_resposta, janelaCliente, painel);
                System.out.println(tf_codigo.getText().length());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });

        painel.add(codCartaoLabel);
        painel.add(tf_codigo);
        painel.add(respostaLabel);
        painel.add(tf_resposta);

        janelaCliente.add(painel);
        janelaCliente.setLocationRelativeTo(null);
        janelaCliente.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        janelaCliente.setVisible(true);

        //Verificação ciclica do valor da resposta
        while (true) {
            if (resposta.equals("ACK")) {
                System.out.println("ACK");
                janelaCliente.getContentPane().setBackground(Color.green);
                painel.setBackground(Color.green);
                esperar(3000);
                tf_codigo.setText("");
                tf_resposta.setText("");
                codigoCartaostr = "";
                resposta = "";
                janelaCliente.getContentPane().setBackground(Color.decode("#eeeeee"));
                painel.setBackground(Color.decode("#eeeeee"));
            } else if (resposta.equals("NACK")) {
                System.out.println("NACK");
                janelaCliente.getContentPane().setBackground(Color.red);
                painel.setBackground(Color.red);
                esperar(3000);
                tf_codigo.setText("");
                tf_resposta.setText("");
                codigoCartaostr = "";
                resposta = "";
                janelaCliente.getContentPane().setBackground(Color.decode("#eeeeee"));
                painel.setBackground(Color.decode("#eeeeee"));
            } else {
                System.out.println("teste");
            }
        }
    }

}