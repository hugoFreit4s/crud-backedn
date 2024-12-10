package com.example.demo.dto;

public class UserCarsResponseDTO {
    private int ID;
    private String ownerName;
    private String name;
    private double value;

    public UserCarsResponseDTO(int ID, String name, String ownerName, double value) {
        this.ID = ID;
        this.name = name;
        this.ownerName = ownerName;
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
