package org.example;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame janela = new JFrame("Exercício 2");
        janela.setSize(500,150);
        janela.setResizable(false);

        JPanel painel = new JPanel(new GridLayout(2,1));

        //Painel pro input do usuário
        JPanel userInputPanel = new JPanel(new FlowLayout());
        JTextField tf = new JTextField(20);
        JButton btnOk = new JButton("ok");
        btnOk.setPreferredSize(new Dimension(50, 20));
        userInputPanel.add(tf);
        userInputPanel.add(btnOk);
        //Mensagem de retorno
        JPanel retornoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel retorno = new JLabel("Retorno: Nenhum");
        retorno.setFont(new Font("Arial", Font.BOLD, 16));
        retornoPanel.add(retorno);

        painel.add(userInputPanel);
        painel.add(retornoPanel);
        janela.add(painel);
        janela.setLocationRelativeTo(null);
        janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        janela.setVisible(true);

    }
}