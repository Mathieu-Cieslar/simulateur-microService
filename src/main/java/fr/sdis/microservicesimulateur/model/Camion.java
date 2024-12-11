package fr.sdis.microservicesimulateur.model;

public class Camion {
    private String id;
    private String centreCamionId;

    public Camion(String id, String centreCamionId, Integer nbPompiers) {
        this.id = id;
        this.centreCamionId = centreCamionId;
    }

    public String getId() {
        return id;
    }

    public String getCentreCamionId() {
        return centreCamionId;
    }

    public void setCentreCamionId(String centreCamionId) {
        this.centreCamionId = centreCamionId;
    }

    public String toString() {
        return "Camion [id=" + id + ", centreCamionId=" + centreCamionId + "]";
    }
}
