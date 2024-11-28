package model;

public class Capteur {
    private String id;
    private Integer intensite;
    private String typeCapteur;

    public Capteur(String id, Integer intensite, String typeCapteur) {
        this.id = id;
        this.intensite = intensite;
        this.typeCapteur = typeCapteur;
    }

    public String getId() {
        return id;
    }

    public Integer getIntensite() {
        return intensite;
    }

    public String getTypeCapteur() {
        return typeCapteur;
    }

    public void setIntensite(Integer intensite) {
        this.intensite = intensite;
    }

    public void setTypeCapteur(String typeCapteur) {
        this.typeCapteur = typeCapteur;
    }

    public String toString() {
        return "Capteur [id=" + id + ", intensite=" + intensite + ", typeCapteur=" + typeCapteur + "]";
    }
}
