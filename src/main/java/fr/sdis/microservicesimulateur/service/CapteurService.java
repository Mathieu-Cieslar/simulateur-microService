package fr.sdis.microservicesimulateur.service;

import fr.sdis.microservicesimulateur.model.Feu;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

@Slf4j
@Service
public class CapteurService {

    double latitudeMAX =45.85;
    double longitudeMIN = 4.70;
    double latitudeMIN = 45.60;
    double longitudeMAX = 5.10;

    private Properties properties = new Properties();

    @Value("${api.url}")
    private String apiUrl;


    public static double distance(double lat1, double lon1, double lat2, double lon2) {
        if ((lat1 == lat2) && (lon1 == lon2)) {
            return 0;
        }
        else {
            double theta = lon1 - lon2;
            double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515 * 1.609344;
            return (dist);
        }
    }

    public void createRandomCapteurs(){
        double latitudesFeu = latitudeMIN + (latitudeMAX - latitudeMIN) * Math.random();
        double longitudesFeu = longitudeMIN + (longitudeMAX - longitudeMIN) * Math.random();
        int intensiteFeu = (int) (1 + Math.random() * 10);
        Feu feuRandom = new Feu(1, latitudesFeu, longitudesFeu, intensiteFeu,0);

        try {
            HttpClient client = HttpClient.newHttpClient();

            log.info("apiUrl : "+apiUrl);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            log.info(response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
