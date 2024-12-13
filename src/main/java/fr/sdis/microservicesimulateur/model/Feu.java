package fr.sdis.microservicesimulateur.model;

import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class Feu {
    private int id;
    private Double coordX;
    private Double coordY;
    private int intensite;
    private int statusIntervention;
}
