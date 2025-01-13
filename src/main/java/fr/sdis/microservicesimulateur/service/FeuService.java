package fr.sdis.microservicesimulateur.service;

import fr.sdis.microservicesimulateur.client.FeuClient;
import fr.sdis.microservicesimulateur.model.Feu;
import fr.sdis.microservicesimulateur.model.Intervention;
import fr.sdis.microservicesimulateur.client.InterventionClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.Calendar;
import java.util.Date;

import java.util.List;

import static fr.sdis.microservicesimulateur.service.CapteurService.distance;

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

    @Autowired
    InterventionClient interventionClient;

    public Feu createRandomFeu() {

        double latitudesFeu = latitudeMIN + (latitudeMAX - latitudeMIN) * Math.random();
        double longitudesFeu = longitudeMIN + (longitudeMAX - longitudeMIN) * Math.random();
        int intensiteFeu = (int) (1 + Math.random() * 10);

        Feu randomFeu = new Feu(1, latitudesFeu, longitudesFeu, intensiteFeu, true);

        return randomFeu;
    }

    public void verifFeu(){
        List<Feu> feux = feuClient.getFeux();
        List<Intervention> interventions = interventionClient.getInterventionsActives();
        System.out.println("Feux : " + interventions);
        Date now = new Date();
        for(Intervention intervention : interventions){
            Feu feuxEmergency = null;
            Feu feuxProche = null;
            for(Feu feu : feux){
                if(feuxProche == null){
                    feuxProche = feu;
                    feuxEmergency = intervention.getFeu();
                } else {
                    if(distance(intervention.getFeu().getCoorX(), intervention.getFeu().getCoorY(), feu.getCoorX(), feu.getCoorY()) < distance(intervention.getFeu().getCoorX(), intervention.getFeu().getCoorY(), feuxProche.getCoorX(), feuxProche.getCoorY())){
                        feuxProche = feu;
                        feuxEmergency = intervention.getFeu();
                    }
                }
                System.out.println("########################");
                System.out.println("Feu le plus proche : " + feuxProche);
                System.out.println("Feu d'urgence : " + feuxEmergency);
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(intervention.getDateIntervention());
            calendar.add(Calendar.MILLISECOND, intervention.getTempsTrajet());
            Date updatedDate = calendar.getTime();
            System.out.println("Date de fin d'intervention : " + updatedDate);
            System.out.println("Date actuelle : " + now);
            if(updatedDate.compareTo(now) < 0){
                System.out.println("Intervention terminée");
                feuClient.desactivateFeu(feuxProche.getId());
                System.out.println(feuxProche.getId());
                feuClient.desactivateFeuEmergency(feuxEmergency.getId());
                System.out.println(feuxEmergency.getId());
            }
            System.out.println("Intervention en cours");
        }
    }
}
