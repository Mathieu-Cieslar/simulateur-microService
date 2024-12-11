package fr.sdis.microservicesimulateur.model;

public class Feu {
    private int id;
    private Double coordX;
    private Double coordY;
    private int intensite;
    private int statusIntervention;

    public Feu(int id, Double coordX, Double coordY, int intensite, int statusIntervention) {
        this.id = id;
        this.coordX = coordX;
        this.coordY = coordY;
        this.intensite = intensite;
        this.statusIntervention = statusIntervention;
    }
    public int getId() {
        return id;
    }
    public Double getCoordX() {
        return coordX;
    }
    public Double getCoordY() {
        return coordY;
    }
    public int getIntensite() {
        return intensite;
    }
    public int getStatusIntervention() {
        return statusIntervention;
    }
    public void setCoordX(Double coordX) {
        this.coordX = coordX;
    }
    public void setCoordY(Double coordY) {
        this.coordY = coordY;
    }
    public void setIntensite(int intensite) {
        this.intensite = intensite;
    }
    public String toString() {
        return "Feu [id=" + id + ", coordX=" + coordX + ", coordY=" + coordY + ", intensite=" + intensite + ", statusIntervention=" + statusIntervention + "]";
    }
}
