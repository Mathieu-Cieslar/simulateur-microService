package fr.sdis.microservicesimulateur;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.sdis.microservicesimulateur.service.CapteurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@Slf4j
@SpringBootApplication
@EnableFeignClients
public class MicroServiceSimulateurApplication {


    public static void main(String[] args) {
        var context = SpringApplication.run(MicroServiceSimulateurApplication.class, args);
        CapteurService capteurService = context.getBean(CapteurService.class);
        capteurService.createRandomCapteurs();
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }


}
