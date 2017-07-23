package com.frankbearzou.javajson;

public class Car {
    private String brand;
    private int doors;

    public Car() {
    }

    public Car(String brand, int doors) {
        this.brand = brand;
        this.doors = doors;
    }

    @Override
    public String toString() {
        return String.format("%s: %d", brand, doors);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }
}
