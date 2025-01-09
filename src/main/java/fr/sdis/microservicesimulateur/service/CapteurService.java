package fr.sdis.microservicesimulateur.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import fr.sdis.microservicesimulateur.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.sdis.microservicesimulateur.service.FeuService;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import fr.sdis.microservicesimulateur.client.*;

@Service
public class CapteurService {

    @Value("${latitudeMAX}")
    double latitudeMAX;
    @Value("${longitudeMIN}")
    double longitudeMIN;
    @Value("${latitudeMIN}")
    double latitudeMIN;
    @Value("${longitudeMAX}")
    double longitudeMAX;

    @Autowired
    FeuService feuService;

    @Autowired
    CapteurClient capteurClient;

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

    public void createRandomCoordCapteurs(){
        List<Capteur> capteurs = capteurClient.getCapteurs();
        for (Capteur capteur : capteurs) {
            double latitudes = latitudeMIN + (latitudeMAX - latitudeMIN) * Math.random();
            double longitudes = longitudeMIN + (longitudeMAX - longitudeMIN) * Math.random();
            capteur.setCoorX(latitudes);
            capteur.setCoorY(longitudes);
        }
        capteurClient.setCapteurs(capteurs);
    }

    public void createRandomCapteurs(){
        //Création d'un feu avec des coordonnées aléatoires et une intensité aléatoire
        Feu feuRandom = feuService.createRandomFeu();

        System.out.println(feuRandom);

        List<Capteur> capteurs = capteurClient.getCapteurs();

        //structure avec un objet

        //Créer une liste de capteurs avec la distance entre le feu et le capteurs



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
