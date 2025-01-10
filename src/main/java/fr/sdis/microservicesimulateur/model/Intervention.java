package fr.sdis.microservicesimulateur.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Intervention {
    private int id;
    private Camion camion;
    private Feu feu;
}
