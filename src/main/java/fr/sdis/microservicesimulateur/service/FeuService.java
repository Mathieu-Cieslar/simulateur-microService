package fr.sdis.microservicesimulateur.service;

import fr.sdis.microservicesimulateur.client.FeuClient;
import fr.sdis.microservicesimulateur.model.Feu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeuService {

    @Value("${latitudeMAX}")
    double latitudeMAX;
    @Value("${longitudeMIN}")
    double longitudeMIN;
    @Value("${latitudeMIN}")
    double latitudeMIN;
    @Value("${longitudeMAX}")
    double longitudeMAX;

    @Autowired
    FeuClient feuClient;

    public Feu createRandomFeu() {

        double latitudesFeu = latitudeMIN + (latitudeMAX - latitudeMIN) * Math.random();
        double longitudesFeu = longitudeMIN + (longitudeMAX - longitudeMIN) * Math.random();
        int intensiteFeu = (int) (1 + Math.random() * 10);

        Feu randomFeu = new Feu(1, latitudesFeu, longitudesFeu, intensiteFeu, null);

        feuClient.addFeu(randomFeu);

        return randomFeu;
    }
}
