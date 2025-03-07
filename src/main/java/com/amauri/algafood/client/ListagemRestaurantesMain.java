package com.amauri.algafood.client;

import com.amauri.algafood.client.api.ClientApiException;
import com.amauri.algafood.client.api.RestauranteClient;
import org.springframework.web.client.RestTemplate;

public class ListagemRestaurantesMain {

    public static void main(String[] args) {
        try {
            RestTemplate restTemplate = new RestTemplate();

            RestauranteClient restauranteClient = new RestauranteClient(restTemplate, "http://localhost:8080");

            restauranteClient.listar()
                    .forEach(System.out::println);

        } catch (ClientApiException e) {
            if(e.getProblem() != null) {
                System.out.println(e.getProblem());
                System.out.println(e.getProblem().getUserMessage());
            } else {
                System.out.println("Erro desconhecido");
                e.printStackTrace();
            }
        }
    }
}
