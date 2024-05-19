package com.example.Gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

@RestController
public class Gateway {
    @Autowired
    private WebClient.Builder webClientBuilder;
    private final ObjectMapper objectMapper;

    public Gateway(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @GetMapping("/api/personas")
    public List<JsonNode> obtenerTodos() {
        List<JsonNode> ciudadanos = webClientBuilder.build()
                .get()
                .uri("http://localhost:90/api/habitantes")
                .retrieve()
                .bodyToFlux(JsonNode.class)
                .collectList()
                .block();

        List<JsonNode> habitantes = webClientBuilder.build()
                .get()
                .uri("http://localhost:100/api/ciudadanos")
                .retrieve()
                .bodyToFlux(JsonNode.class)
                .collectList()
                .block();

        Desambiguador desambiguador = new Desambiguador(objectMapper);
        return desambiguador.desambiguar(ciudadanos, habitantes);
    }
}
