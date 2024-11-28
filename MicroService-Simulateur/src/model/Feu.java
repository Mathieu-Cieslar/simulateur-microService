package model;

public class Feu {
    private String id;
    private Integer coordX;
    private Integer coordY;
    private Integer intensite;

    public Feu(String id, Integer coordX, Integer coordY, Integer intensite) {
        this.id = id;
        this.coordX = coordX;
        this.coordY = coordY;
        this.intensite = intensite;
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

    public Integer getIntensite() {
        return intensite;
    }

    public void setCoordX(Integer coordX) {
        this.coordX = coordX;
    }

    public void setCoordY(Integer coordY) {
        this.coordY = coordY;
    }

    public void setIntensite(Integer intensite) {
        this.intensite = intensite;
    }

    public String toString() {
        return "Feu [id=" + id + ", coordX=" + coordX + ", coordY=" + coordY + ", intensite=" + intensite + "]";
    }
    
}
