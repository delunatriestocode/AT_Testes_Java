package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.example.Calculo.*;

public class Main {
    public static void main(String[] args) {
        JFrame janela = new JFrame("AT Gabriel Silveira");
        janela.setSize(500,300);

        JPanel panel = new JPanel(new GridLayout(6,1));
        //SOMA, SUBTRAÇÃO E MÓDULO

        //Linha 1
        JPanel l1_1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel n1L_1 = new JLabel("n1(z1) = ");
        JTextField n1TF_1 = new JTextField(15);
        l1_1.add(n1L_1);
        l1_1.add(n1TF_1);
        //Linha 2
        JPanel l2_1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel n2L_1 = new JLabel("n2(z1) = ");
        JTextField n2TF_1 = new JTextField(15);
        l2_1.add(n2L_1);
        l2_1.add(n2TF_1);
        //Linha 3
        JPanel l1_2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel n1L_2 = new JLabel("n1(z2) = ");
        JTextField n1TF_2 = new JTextField(15);
        l1_2.add(n1L_2);
        l1_2.add(n1TF_2);
        //Linha 4
        JPanel l2_2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel n2L_2 = new JLabel("n2(z2) = ");
        JTextField n2TF_2 = new JTextField(15);
        l2_2.add(n2L_2);
        l2_2.add(n2TF_2);
        //Linha 5
        JLabel resultado = new JLabel("Resultado = ");

        //Botões
        JPanel btnPanel = new JPanel(new GridLayout(1, 3));
        JButton btn_soma = new JButton("Soma");
        JButton btn_subracao = new JButton("Subtração");
        JButton btn_modulo = new JButton("Módulo");
        btnPanel.add(btn_soma);
        btnPanel.add(btn_subracao);
        btnPanel.add(btn_modulo);

        panel.add(l1_1);
        panel.add(l2_1);
        panel.add(l1_2);
        panel.add(l2_2);
        panel.add(resultado);
        panel.add(btnPanel);
        janela.add(panel);
        janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);

        //Ação dos botões
        btn_soma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultado.setText(botaoSoma(n1TF_1, n2TF_1, n1TF_2, n2TF_2));
            }
        });
        btn_subracao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultado.setText(botaoSub(n1TF_1, n2TF_1, n1TF_2, n2TF_2));
            }
        });
    }
}