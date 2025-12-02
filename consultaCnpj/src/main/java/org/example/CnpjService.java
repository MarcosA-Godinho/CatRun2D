package org.example;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class CnpjService {

    // Metodo que recebe o CNPJ e retorna o Objeto pronto (ou null se der erro)
    public CnpjData buscarCnpj(String cnpj) {
        // Limpeza básica
        String cnpjLimpo = cnpj.replaceAll("[^0-9]", "");
        //String url = "https://brasilapi.com.br/api/cnpj/v1/" + cnpjLimpo;
        //String url = "https://minhareceita.org/" + cnpjLimpo;
        String url = "https://www.receitaws.com.br/v1/cnpj/" + cnpjLimpo;

        try {
            HttpClient client = HttpClient.newBuilder()
                    .connectTimeout(Duration.ofSeconds(10))
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {

               // System.out.println("DEBUG JSON: " + response.body());

                Gson gson = new Gson();
                return gson.fromJson(response.body(), CnpjData.class);
            } else {
                System.out.println("Erro na API: " + response.statusCode());
                return null;
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("Erro de conexão: " + e.getMessage());
            return null;
        }
    }
}