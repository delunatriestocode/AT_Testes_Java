package org.example;

import javax.swing.*;

public class Complexo {
    public static String botaoSoma(JTextField TF_11, JTextField TF_21, JTextField TF_12, JTextField TF_22) {
        String res = "";
        try {
            if (TF_11.getText().isEmpty() || TF_21.getText().isEmpty() || TF_12.getText().isEmpty() || TF_22.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "ERRO: Um ou mais campos são inválidos");
            } else {
                int n1_1 = Integer.parseInt(TF_11.getText());
                int n2_1 = Integer.parseInt(TF_21.getText());
                int n1_2 = Integer.parseInt(TF_12.getText());
                int n2_2 = Integer.parseInt(TF_22.getText());
                res = "Resultado: " + Integer.toString(n1_1 + n1_2) + " + " + Integer.toString(n2_1 + n2_2) + "i";
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "ERRO: Um ou mais campos são inválidos");
        }
        return res;
    }
    public static String botaoSub(JTextField TF_11, JTextField TF_21, JTextField TF_12, JTextField TF_22) {
        String res = "";
        try {
            if (TF_11.getText().isEmpty() || TF_21.getText().isEmpty() || TF_12.getText().isEmpty() || TF_22.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "ERRO: Um ou mais campos são inválidos");
            } else {
                int n1_1 = Integer.parseInt(TF_11.getText());
                int n2_1 = Integer.parseInt(TF_21.getText());
                int n1_2 = Integer.parseInt(TF_12.getText());
                int n2_2 = Integer.parseInt(TF_22.getText());
                res = "Resultado: " + Integer.toString(n1_1 - n1_2) + " - " + Integer.toString(n2_1 - n2_2) + "i";
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "ERRO: Um ou mais campos são inválidos");
        }
        return res;
    }
    public static String botaoMod(JTextField TF_11, JTextField TF_21, JTextField TF_12, JTextField TF_22) {
        String res = "";
        try {
            if (TF_11.getText().isEmpty() || TF_21.getText().isEmpty() || TF_12.getText().isEmpty() || TF_22.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "ERRO: Um ou mais campos são inválidos");
            } else {
                double n1_1 = Double.parseDouble(TF_11.getText());
                double n2_1 = Integer.parseInt(TF_21.getText());
                double n1_2 = Integer.parseInt(TF_12.getText());
                double n2_2 = Integer.parseInt(TF_22.getText());
                double resultadoConta = Math.pow(n1_1, 2) + Math.pow(n2_1, 2);
                int resultadoContaZ1 = (int)resultadoConta;
                resultadoConta = Math.pow(n1_2, 2) + Math.pow(n2_2, 2);
                int resultadoContaZ2 = (int)resultadoConta;
                res = "Resultado: |z1| = √" + Integer.toString(resultadoContaZ1) + " // |z2| = √" + Integer.toString(resultadoContaZ2);
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "ERRO: Um ou mais campos são inválidos");
        }
        return res;
    }
}
