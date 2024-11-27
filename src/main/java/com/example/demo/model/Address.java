package com.example.demo.model;

public class Address {
    private String street;
    private int houseNumber;
    private String neighborhood;
    private String city;

    public Address(String street, int houseNumber, String neighborhood, String city) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.neighborhood = neighborhood;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
