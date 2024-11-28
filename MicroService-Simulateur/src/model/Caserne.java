package model;

public class Caserne {
    private String id;
    private Integer coordX;
    private Integer coordY;
    private Integer nbCamions;
    private Integer nbPompiers;

    public Caserne(String id, Integer coordX, Integer coordY, Integer nbCamions, Integer nbPompiers) {
        this.id = id;
        this.coordX = coordX;
        this.coordY = coordY;
        this.nbCamions = nbCamions;
        this.nbPompiers = nbPompiers;
    }

    public String getId() {
        return id;
    }

    public Integer getCoordX() {
        return coordX;
    }

    public Integer getCoordY() {
        return coordY;
    }

    public Integer getNbCamions() {
        return nbCamions;
    }

    public Integer getNbPompiers() {
        return nbPompiers;
    }

    public void setNbCamions(Integer nbCamions) {
        this.nbCamions = nbCamions;
    }

    public void setNbPompiers(Integer nbPompiers) {
        this.nbPompiers = nbPompiers;
    }

    public String toString() {
        return "Caserne [id=" + id + ", coordX=" + coordX + ", coordY=" + coordY + ", nbCamions=" + nbCamions + ", nbPompiers=" + nbPompiers + "]";
    }
}
