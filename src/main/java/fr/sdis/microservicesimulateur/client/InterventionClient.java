package fr.sdis.microservicesimulateur.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.sdis.microservicesimulateur.model.Feu;
import fr.sdis.microservicesimulateur.model.Intervention;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class InterventionClient {
    @Value("${api.url}/intervention")
    private String apiUrl;

    @Value("${api.url2}/intervention")
    private String apiUrl2;

    private final RestTemplate restTemplate;
    public InterventionClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    ObjectMapper objectMapper = new ObjectMapper();

    public List<Intervention> getInterventions() {
        String reponse = null;
        try{
            reponse = restTemplate.getForObject(apiUrl, String.class);
            System.out.println(reponse);
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la récupération des interventions", e);
        }

        try {
            // Désérialisation
            return objectMapper.readValue(reponse, new TypeReference<List<Intervention>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la conversion en JSON", e);
        }
    }

    public List<Intervention> getInterventionsActives() {
        String reponse = null;
        try{
            reponse = restTemplate.getForObject(apiUrl2+"/actif", String.class);
            System.out.println(reponse);
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la récupération des interventions", e);
        }

        try {
            // Désérialisation
            return objectMapper.readValue(reponse, new TypeReference<List<Intervention>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la conversion en JSON", e);
        }
    }

    public void createIntervention(Intervention intervention) {
        String json = null;
        try {
            json = objectMapper.writeValueAsString(intervention);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erreur lors de la conversion en JSON", e);
        }

        try{
            restTemplate.postForObject(apiUrl, json, String.class);
            System.out.println("Post success");

        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la création d'un intervention", e);
        }
    }
}
