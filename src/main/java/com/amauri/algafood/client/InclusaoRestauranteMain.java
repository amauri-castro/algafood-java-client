package com.amauri.algafood.client;

import com.amauri.algafood.client.api.ClientApiException;
import com.amauri.algafood.client.api.RestauranteClient;
import com.amauri.algafood.client.model.RestauranteModel;
import com.amauri.algafood.client.model.input.CidadeIdInput;
import com.amauri.algafood.client.model.input.CozinhaIdInput;
import com.amauri.algafood.client.model.input.EnderecoInput;
import com.amauri.algafood.client.model.input.RestauranteInput;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

public class InclusaoRestauranteMain {
    public static void main(String[] args) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            RestauranteClient restauranteClient = new RestauranteClient(restTemplate, "http://localhost:8080");

            CozinhaIdInput cozinha = new CozinhaIdInput();
            cozinha.setId(1L);

            CidadeIdInput cidade = new CidadeIdInput();
            cidade.setId(1L);

            EnderecoInput endereco = new EnderecoInput();
            endereco.setCidade(cidade);
            endereco.setCep("6565-565");
            endereco.setLogradouro("Rua Pereira");
            endereco.setNumero("450");
            endereco.setBairro("Aeroporto");

            RestauranteInput restaurante = new RestauranteInput();
            restaurante.setNome("Comida do Sertão");
            restaurante.setTaxaFrete(new BigDecimal("7.8"));
            restaurante.setCozinha(new CozinhaIdInput());
            restaurante.setCozinha(cozinha);
            restaurante.setEndereco(endereco);

            RestauranteModel restauranteSalvo = restauranteClient.salvar(restaurante);
            System.out.println(restauranteSalvo);

        } catch (ClientApiException e) {
            if(e.getProblem() != null) {
                System.out.println(e.getProblem().getUserMessage());

                e.getProblem().getObjects().forEach(System.out::println);

            } else {
                System.out.println("Aconteceu um erro desconhecido");
                e.printStackTrace();
            }
        }



    }
}
