package org.example;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static org.example.Main.*;

public class Methods {
    public static void esperar(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }
    public static void verificarValorResposta(JTextField tfC, JTextField tfR, JFrame janela, JPanel painel) {
        codigoCartaostr = tfC.getText();
        String path = "http://localhost:8080/api";

        String content = "{\"codigo\": \"" + codigoCartaostr + "\"}";
        System.out.println(content);

        //Checar se tem alguma coisa escrita na caixa de texto
        if (!tfC.getText().isEmpty() && tfC.getText().length() == 10) {
            codigoCartaostr = tfC.getText();
            try {
                URL url = new URL(path);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setDoOutput(true);

                DataOutputStream out = new DataOutputStream(connection.getOutputStream());
                out.writeBytes(content);
                out.flush();
                out.close();
                int responseCode = connection.getResponseCode();
                System.out.println("Response code: " + responseCode);
                if (responseCode != HttpURLConnection.HTTP_OK) {
                    System.out.println("Ocorreu um erro.");
                }
                BufferedReader in =  new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                    JsonElement jsonElement = JsonParser.parseString(line);
                    JsonObject jsonObject = jsonElement.getAsJsonObject();
                    tfR.setText(jsonObject.get("Response").getAsString());
                }
                in.close();
            } catch (MalformedURLException e) {
                System.out.println(e);
            } catch (IOException e) {
                System.out.println(e);
            }
            resposta = tfR.getText();
        } else {
            System.out.println("vazia");
        }
    }
}
