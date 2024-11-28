package fr.sdis.service;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FireService {

    @PostConstruct
    public void init() {
        System.out.println("Ceci est un message dans la console !");
    }
    public void startFire() {

    }

}
