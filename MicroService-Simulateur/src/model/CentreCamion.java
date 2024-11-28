package model;

public class CentreCamion {
    private String id;
    private Integer coordX;
    private Integer coordY;

    public CentreCamion(String id, Integer coordX, Integer coordY) {
        this.id = id;
        this.coordX = coordX;
        this.coordY = coordY;
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

    public String toString() {
        return "CentreCamion [id=" + id + ", coordX=" + coordX + ", coordY=" + coordY + "]";
    }
}
