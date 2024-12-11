package fr.sdis.microservicesimulateur.model;

public class Caserne {
    private int idCamion;
    private int idIntervention;
    private int tempsIntervention;

    public Caserne(int idCamion, int idIntervention, int tempsIntervention) {
        this.idCamion = idCamion;
        this.idIntervention = idIntervention;
        this.tempsIntervention = tempsIntervention;
    }
    public int getIdCamion() {
        return idCamion;
    }
    public int getIdIntervention() {
        return idIntervention;
    }
    public int getTempsIntervention() {
        return tempsIntervention;
    }
    public void setIdCamion(int idCamion) {
        this.idCamion = idCamion;
    }
    public void setIdIntervention(int idIntervention) {
        this.idIntervention = idIntervention;
    }
    public void setTempsIntervention(int tempsIntervention) {
        this.tempsIntervention = tempsIntervention;
    }
    public String toString() {
        return "CamionHasIntervention [idCamion=" + idCamion + ", idIntervention=" + idIntervention + ", tempsIntervention=" + tempsIntervention + "]";
    }
}
