package fr.sdis.microservicesimulateur.model;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Intervention {
    private int id;
    private List<Camion> camions;
    private Feu feu;
    private Caserne caserne;
    private List<Double[]> trajet;
    private Integer tempsTrajet;
    private Date dateIntervention;
}
