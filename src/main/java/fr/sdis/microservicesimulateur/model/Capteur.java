package fr.sdis.microservicesimulateur.model;

public class Capteur {
    private String id;
    private Integer value;
    private String typeCapteur;
    private Double coordX;
    private Double coordY;

    public Capteur(String id, Integer value, String typeCapteur, Double coordX, Double coordY) {
        this.id = id;
        this.value = value;
        this.typeCapteur = typeCapteur;
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public String getId() {
        return id;
    }

    public Integer getvalue() {
        return value;
    }

    public String getTypeCapteur() {
        return typeCapteur;
    }

    public Double getCoordX() {
        return coordX;
    }

    public Double getCoordY() {
        return coordY;
    }

    public void setvalue(Integer value) {
        this.value = value;
    }

    public void setTypeCapteur(String typeCapteur) {
        this.typeCapteur = typeCapteur;
    }
    public void setCoordX(Double coordX) {
        this.coordX = coordX;
    }
    public void setCoordY(Double coordY) {
        this.coordY = coordY;
    }

    public String toString() {
        return "Capteur [id=" + id + ", value=" + value + ", typeCapteur=" + typeCapteur + ", coordX=" + coordX + ", coordY=" + coordY + "]";
    }
}
