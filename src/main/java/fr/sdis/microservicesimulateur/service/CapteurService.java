package fr.sdis.microservicesimulateur.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import fr.sdis.microservicesimulateur.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import fr.sdis.microservicesimulateur.client.*;

@Service
public class CapteurService {

    private final CapteurClient capteurClient;

    public CapteurService(CapteurClient capteurClient) {
        this.capteurClient = capteurClient;
    }

    double latitudeMAX = 45.85;
    double longitudeMIN = 4.70;
    double latitudeMIN = 45.60;
    double longitudeMAX = 5.10;

    private Properties properties = new Properties();

    @Value("${api.url}"+"capteur")
    private String apiUrl;


    public static double distance(double lat1, double lon1, double lat2, double lon2) {
        if ((lat1 == lat2) && (lon1 == lon2)) {
            return 0;
        } else {
            double theta = lon1 - lon2;
            double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515 * 1.609344;
            return (dist);
        }
    }

    public void createRandomCapteurs(){
        //Création d'un feu avec des coordonnées aléatoires et une intensité aléatoire
        double latitudesFeu = latitudeMIN + (latitudeMAX - latitudeMIN) * Math.random();
        double longitudesFeu = longitudeMIN + (longitudeMAX - longitudeMIN) * Math.random();
        int intensiteFeu = (int) (1 + Math.random() * 10);
        Feu feuRandom = new Feu(1, latitudesFeu, longitudesFeu, intensiteFeu, 0);

        List<Capteur> capteurs = capteurClient.getCapteurs();

        //On crée une liste de capteurs proches du feu
        List<Capteur> capteursProches = new ArrayList<>();
        for (Capteur capteur : capteurs) {
            //distance entre le capteur et le feu
            double distance = distance(capteur.getCoorX(), capteur.getCoorY(), feuRandom.getCoordX(), feuRandom.getCoordY());
            if(distance < 3){
                capteur.setValeur(10);
                capteursProches.add(capteur);
            }else if(distance < 4){
                capteur.setValeur(9);
                capteursProches.add(capteur);
            }else if(distance < 5){
                capteur.setValeur(8);
                capteursProches.add(capteur);
            }else if(distance < 6){
                capteur.setValeur(7);
                capteursProches.add(capteur);
            }else if(distance < 7){
                capteur.setValeur(6);
                capteursProches.add(capteur);
            }else if(distance < 8){
                capteur.setValeur(5);
                capteursProches.add(capteur);
            }else if(distance < 9){
                capteur.setValeur(4);
                capteursProches.add(capteur);
            }else if(distance < 10){
                capteur.setValeur(3);
                capteursProches.add(capteur);
            }else if (distance < 11){
                capteur.setValeur(2);
                capteursProches.add(capteur);
            }else if (distance < 12){
                capteur.setValeur(1);
                capteursProches.add(capteur);
            }else {
                capteur.setValeur(0);
                capteursProches.add(capteur);
            }
        }
        for (Capteur capteur : capteursProches) {
            System.out.println(capteur.toString());
        }

        capteurClient.setCapteurs(capteurs);

    }
}
