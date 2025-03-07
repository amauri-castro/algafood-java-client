package com.amauri.algafood.client;

import com.amauri.algafood.client.api.RestauranteClient;
import org.springframework.web.client.RestTemplate;

public class InclusaoRestauranteMain {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        RestauranteClient restauranteClient = new RestauranteClient(restTemplate, "http://localhost:8080");
    }
}
