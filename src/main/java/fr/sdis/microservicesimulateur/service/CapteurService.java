package fr.sdis.microservicesimulateur.service;

import ch.qos.logback.core.joran.sanity.Pair;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import fr.sdis.microservicesimulateur.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.sdis.microservicesimulateur.service.FeuService;

import java.sql.Struct;
import java.util.*;
import java.util.stream.Collectors;

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
    @Autowired
    private FeuClient feuClient;


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

        //Recupération de la liste des feux
        List<Feu> feux = feuClient.getFeux();


        Feu feuRandom;
        //Création d'un feu avec des coordonnées aléatoires et une intensité aléatoire si la tailel de la liste feu est inferieur ou égal à 5
        if(feux.size() < 1){
            //Condition aléatoire pour créer un feu
            if (Math.random() < 0.5) {
                feuRandom = feuService.createRandomFeu();
                feux = feuClient.getFeux();
                feuClient.addFeu(feuRandom);
            }else{
                System.out.println("Pas de feu créééééééééééééééééé");
            }
        }else{
            System.out.println("Il y a déjà 6 feux");
        }


        List<Capteur> capteurs = capteurClient.getCapteurs();

        if(!feux.isEmpty() && !feux.getLast().isStatus()){
            for(Capteur capteur : capteurs){
                capteur.setValeur(0);
            }
        }else{

            for (Feu feu : feux) {
                //Liste avec capteur et la distance entre le capteur et le feu
                Map<Capteur, Double> myMap = new HashMap<>();
                for (Capteur capteur : capteurs) {
                    //distance entre le capteur et le feu
                    double distance = distance(capteur.getCoorX(), capteur.getCoorY(), feu.getCoorX(), feu.getCoorY());
                    myMap.put(capteur, distance);
                }

                // Tri de la HashMap par valeurs (distance) en ordre décroissant
                Map<Capteur, Double> sortedMap = myMap.entrySet()
                        .stream()
                        .sorted(Map.Entry.<Capteur, Double>comparingByValue(Comparator.naturalOrder()))
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (oldValue, newValue) -> oldValue,
                                LinkedHashMap::new
                        ));

                //On crée une liste de capteurs proches du feu
                List<Capteur> capteursProches = new ArrayList<>();
                int index = 0;
                System.out.println(feu);
                for (Map.Entry<Capteur, Double> entry : sortedMap.entrySet()) {
                    Capteur capteur = entry.getKey();
                    Double distance = entry.getValue();
                    if(capteur.getValeur()==null){
                        capteur.setValeur(0);
                    }
                    if (index < 3) {
                        System.out.println("Capteur : " + capteur + " Distance : " + distance);
                        capteur.setValeur(9);
                        capteursProches.add(capteur);
                    } else if (distance < 5 & capteur.getValeur() < 8) {
                        capteur.setValeur(8);
                        capteursProches.add(capteur);
                    } else if (distance < 6 & capteur.getValeur() < 7) {
                        capteur.setValeur(7);
                        capteursProches.add(capteur);
                    } else if (distance < 7 & capteur.getValeur() < 6) {
                        capteur.setValeur(6);
                        capteursProches.add(capteur);
                    } else if (distance < 8 & capteur.getValeur() < 5) {
                        capteur.setValeur(5);
                        capteursProches.add(capteur);
                    } else if (distance < 9 & capteur.getValeur() < 4) {
                        capteur.setValeur(4);
                        capteursProches.add(capteur);
                    } else if (distance < 10 & capteur.getValeur() < 3) {
                        capteur.setValeur(3);
                        capteursProches.add(capteur);
                    } else if (distance < 11 & capteur.getValeur() < 2) {
                        capteur.setValeur(2);
                        capteursProches.add(capteur);
                    } else if (distance < 12 & capteur.getValeur() < 1) {
                        capteur.setValeur(1);
                        capteursProches.add(capteur);
                    } else {
                        //capteur.setValeur(0);
                        capteursProches.add(capteur);
                    }
                    index++;
                }
            }
        }

        capteurClient.setCapteurs(capteurs);
        System.out.println("Capteurs mis à jour");

    }
}
