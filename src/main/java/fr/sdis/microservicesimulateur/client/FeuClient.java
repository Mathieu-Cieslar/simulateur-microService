package fr.sdis.microservicesimulateur.client;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.sdis.microservicesimulateur.model.Capteur;
import fr.sdis.microservicesimulateur.model.Feu;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FeuClient {
    @Value("${api.url}/feu")
    private String apiUrl;

    @Value("${api.url2}/feu")
    private String apiUrl2;

    private final RestTemplate restTemplate;
    public FeuClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    ObjectMapper objectMapper = new ObjectMapper();

    public List<Feu> getFeux() {
        String reponse = null;
        try{
            reponse = restTemplate.getForObject(apiUrl, String.class);
            System.out.println(reponse);
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la récupération des feux", e);
        }

        try {
            // Désérialisation
            return objectMapper.readValue(reponse, new TypeReference<List<Feu>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la conversion en JSON", e);
        }
    }

    public List<Feu> getFeuxEmergency() {
        String reponse = null;
        try{
            reponse = restTemplate.getForObject(apiUrl, String.class);
            System.out.println(reponse);
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la récupération des feux", e);
        }

        try {
            // Désérialisation
            return objectMapper.readValue(reponse, new TypeReference<List<Feu>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la conversion en JSON", e);
        }
    }

    public void desactivateFeu(int id) {
        try {
            restTemplate.put(apiUrl + "/close/" + id, String.class);
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la mise à jour des feux", e);
        }
    }

    public void desactivateFeuEmergency(int id) {
        try {
            restTemplate.put(apiUrl2 + "/close/" + id, String.class);
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la mise à jour des feux", e);
        }
    }

    public void setFeux(List<Feu> feu) {
        String json = null;
        try {
            json = objectMapper.writeValueAsString(feu);
            System.out.println("Update success");
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erreur lors de la conversion en JSON", e);
        }

        try{
            restTemplate.put(apiUrl, json);
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la mise à jour des feux", e);
        }
    }

    public void addFeu(Feu feu) {
        String json = null;
        try {
            json = objectMapper.writeValueAsString(feu);
            System.out.println("Add success");
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erreur lors de la conversion en JSON", e);
        }

        try{
            restTemplate.postForEntity(apiUrl, json, String.class);
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de l'ajout du feu", e);
        }
    }

}
