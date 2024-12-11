package fr.sdis.microservicesimulateur.client;

import fr.sdis.microservicesimulateur.model.Capteur;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;


@FeignClient(name = "capteur-client", url = "${api.url}")
public interface CapteurClient {

        @GetMapping("/getAllcapteurs")
        List<Capteur> getAllcapteurs();
}
