package com.example.demo.dto;

public class UserCarsResponseDTO {
    private int ID;
    private String ownerName;
    private String brand;
    private String modelName;
    private int manufactureYear;
    private String name;
    private double value;

    public UserCarsResponseDTO(int ID, String brand, String modelName, String ownerName, double value, int manufactureYear) {
        this.ID = ID;
        this.name = brand + " " + modelName;
        this.brand = brand;
        this.modelName = modelName;
        this.ownerName = ownerName;
        this.value = value;
        this.manufactureYear = manufactureYear;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }
}
