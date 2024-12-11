package fr.sdis.microservicesimulateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.sdis.microservicesimulateur.service.CapteurService;

@SpringBootApplication
public class MicroServiceSimulateurApplication {

    @Autowired
    private CapteurService capteurService;

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceSimulateurApplication.class, args);
        System.out.println("Hello, Woeerld!");
        System.out.println(CapteurService.distance(48.866667, 2.333333,45.750000, 4.850000)+ " Km");
        //capteurService.createRandomCapteurs();
    }

}
