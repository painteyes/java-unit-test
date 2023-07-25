package com.example.reservations;

public class Table {

    private String nominative;

    public boolean isAvailable() {
        return nominative == null || nominative.length() == 0;
    }

    public void bookFor(String nominative) {
        this.nominative = nominative;
    }

    public void vacate() {
        nominative = null;
    }

    public String getNominative() {
        return nominative;
    }
}
