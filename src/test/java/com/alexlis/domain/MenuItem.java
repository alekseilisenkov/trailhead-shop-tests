package com.alexlis.domain;

public enum MenuItem {
    CAR("Машина"),
    TRAIN("Поезд"),
    PLANE("Самолёт");

    private String description;

    MenuItem(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
