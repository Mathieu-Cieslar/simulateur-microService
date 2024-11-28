package model;

public class Camion {
    private String id;
    private String centreCamionId;
    private Integer nbPompiers;

    public Camion(String id, String centreCamionId, Integer nbPompiers) {
        this.id = id;
        this.centreCamionId = centreCamionId;
        this.nbPompiers = nbPompiers;
    }

    public String getId() {
        return id;
    }

    public String getCentreCamionId() {
        return centreCamionId;
    }

    public Integer getNbPompiers() {
        return nbPompiers;
    }

    public void setCentreCamionId(String centreCamionId) {
        this.centreCamionId = centreCamionId;
    }

    public void setNbPompiers(Integer nbPompiers) {
        this.nbPompiers = nbPompiers;
    }

    public String toString() {
        return "Camion [id=" + id + ", centreCamionId=" + centreCamionId + ", nbPompiers=" + nbPompiers + "]";
    }
}
