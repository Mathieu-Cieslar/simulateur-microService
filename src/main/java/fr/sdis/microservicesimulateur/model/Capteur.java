package fr.sdis.microservicesimulateur.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Capteur {
    public String id;
    public Double coorX;
    public Double coorY;
    public String typeCapteur;
    public Integer valeur;


    public String toString() {
        return "Capteur{" +
                "id='" + id + '\'' +
                ", coorX=" + coorX +
                ", coorY=" + coorY +
                ", typeCapteur='" + typeCapteur + '\'' +
                ", valeur=" + valeur +
                '}';
    }
}
