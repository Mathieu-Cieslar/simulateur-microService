package fr.sdis.microservicesimulateur;

import fr.sdis.microservicesimulateur.client.CapteurClient;
import fr.sdis.microservicesimulateur.service.CapteurService;
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
        var context = SpringApplication.run(MicroServiceSimulateurApplication.class, args);
        CapteurService capteurService = context.getBean(CapteurService.class);
        System.out.println("Hello, Woeerld!");
        System.out.println(capteurService.distance(48.866667, 2.333333,45.750000, 4.850000)+ " Km");
        capteurService.createRandomCapteurs();
    }

}
