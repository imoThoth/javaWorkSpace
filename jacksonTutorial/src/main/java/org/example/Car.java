package org.example;

public class Car {
    private String colour, type, manufacturer;
    private int speed, seating;

    public Car(int speed, int seating, long distance, boolean warranty) {
        this.speed = speed;
        this.seating = seating;
        this.distance = distance;
        this.warranty = warranty;
    }

    private long distance;
    private boolean warranty;

    public Car(String colour, String type, String manufacturer) {
        this.colour = colour;
        this.type = type;
        this.manufacturer = manufacturer;
    }

    public Car(){}

    public Car(String colour, String type, String manufacturer, int speed, int seating, long distance, boolean warranty){

    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSeating() {
        return seating;
    }

    public void setSeating(int seating) {
        this.seating = seating;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    public boolean isWarranty() {
        return warranty;
    }

    public void setWarranty(boolean warranty) {
        this.warranty = warranty;
    }
}
