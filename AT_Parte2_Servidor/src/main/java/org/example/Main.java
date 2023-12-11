
package org.example;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.swing.*;
import  java.awt.*;
import  java.awt.event.ActionEvent;
import  java.awt.event.ActionListener;
import static spark.Spark.*;

import static org.example.Methods.*;

public class Main {
    static String codigoCartaoValido = "12345678";

    public static void main(String[] args) {
        JFrame janelaServidor = new JFrame("Exercício 2 (Servidor)");
        janelaServidor.setSize(300,150);
        janelaServidor.setResizable(false);

        JPanel painel = new JPanel(new GridLayout(2,2));

        JLabel codCartaoLabel = new JLabel("Código:");
        codCartaoLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        JTextField tf_codigo = new JTextField(20);
        JLabel respostaLabel = new JLabel("Resposta:");
        respostaLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        JTextField tf_resposta = new JTextField(20);

        port(8080);
        get("/codigocartao", (req, res) ->
        {
            String codigo = req.queryParams("codigo");
            tf_codigo.setText(codigo);

            return "Olá";
        });

        post("/api", (req, res) -> {
            String corpoRequisicao = req.body();
            System.out.println("Corpo JSON: " + corpoRequisicao);

            JsonElement jsonElement = JsonParser.parseString(corpoRequisicao);
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            tf_codigo.setText(jsonObject.get("codigo").getAsString());

            String response = "";

            if (jsonObject.get("codigo").getAsString().equals(codigoCartaoValido)) {
                response = "ACK";
            } else {
                response = "NACK";
            }
            tf_resposta.setText(response);
            return "{\"Response\": \"" + response + "\"}";
        });

        painel.add(codCartaoLabel);
        painel.add(tf_codigo);
        painel.add(respostaLabel);
        painel.add(tf_resposta);

        janelaServidor.add(painel);
        janelaServidor.setLocationRelativeTo(null);
        janelaServidor.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        janelaServidor.setVisible(true);
    }
}