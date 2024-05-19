package com.example.Gateway;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Desambiguador {
    private final ObjectMapper objectMapper;

    public Desambiguador(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public List<JsonNode> desambiguar(List<JsonNode> ciudadanos, List<JsonNode> habitantes) {
        List<JsonNode> personas = new ArrayList<>();

        // Agregar todos los ciudadanos primero
        personas.addAll(ciudadanos);

        // Agregar habitantes solo si no están en la lista de ciudadanos
        for (JsonNode habitante : habitantes) {
            boolean existe = personas.stream().anyMatch(persona ->
                    persona.get("nombre").asText().equalsIgnoreCase(habitante.get("nombre").asText()) &&
                            persona.get("apellido").asText().equalsIgnoreCase(habitante.get("apellido").asText()) &&
                            persona.get("identificacion").asText().equalsIgnoreCase(habitante.get("identificacion").asText())
            );
            if (!existe) {
                personas.add(habitante);
            }
        }

        return personas;
    }
}

