package com.example.demo.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Nonnull
    private String name;
    @ManyToOne
    @JoinColumn(name = "owner_ID", referencedColumnName = "ID")
    private User owner;

    public Car() {
    }

    public Car(String name, User owner) {
        this.name = name;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
