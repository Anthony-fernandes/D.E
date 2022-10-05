package br.edu.catolica.pp;

public class Dados {
    int area;
    int rooms;
    int bathroom;

    public Dados(int area, int rooms, int bathroom) {
        this.area = area;
        this.rooms = rooms;
        this.bathroom = bathroom;
    }

    public float getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public float getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public float getBathroom() {
        return bathroom;
    }

    public void setBathroom(int bathroom) {
        this.bathroom = bathroom;
    }

    @Override
    public String toString() {
        return "Dados{" +
                "area=" + area +
                ", rooms=" + rooms +
                ", bathroom=" + bathroom +
                '}';
    }
}
