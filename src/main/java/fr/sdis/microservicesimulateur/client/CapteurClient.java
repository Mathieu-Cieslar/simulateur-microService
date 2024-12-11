package fr.sdis.microservicesimulateur.client;

import fr.sdis.microservicesimulateur.model.Capteur;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@FeignClient(name = "capteur-client", url = "${api.url}")
public interface CapteurClient {

        @GetMapping("/getAllcapteurs")
        List<Capteur> getAllcapteurs();
}
