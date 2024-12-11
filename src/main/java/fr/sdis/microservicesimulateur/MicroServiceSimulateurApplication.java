package fr.sdis.microservicesimulateur;

import fr.sdis.microservicesimulateur.client.CapteurClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@Slf4j
@SpringBootApplication
@EnableFeignClients
public class MicroServiceSimulateurApplication {



    public static void main(String[] args) {
        SpringApplication.run(MicroServiceSimulateurApplication.class, args);
        System.out.println("Hello, Woeerld!");
        log.info("TEST LOGGER");
        //System.out.println(CapteurService.distance(48.866667, 2.333333,45.750000, 4.850000)+ " Km");
        // CapteurService.createRandomCapteurs();
    }

}
