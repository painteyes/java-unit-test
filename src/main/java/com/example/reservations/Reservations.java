package com.example.reservations;

public class Reservations {

    private final Restaurant restaurant;

    public Reservations(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public int getNumberOfAvailableTables() {
        int availableTables = 0;
        for (Table table : restaurant.getTables()) {
            if (table.isAvailable()) {
                availableTables++;
            }
        }
        return availableTables;
    }

    public Table findAvailableTable() {
        for (Table table : restaurant.getTables()) {
            if (table.isAvailable()) {
                return table;
            }
        }
        return null;
    }

    public void book(String nominative) throws Exception {
        if (getNumberOfAvailableTables() == 0) {
            throw new Exception("No available tables.");
        }

        Table availableTable = findAvailableTable();
        if (availableTable != null) {
            availableTable.bookFor(nominative);
        } else {
            throw new Exception("Unexpected error occurred while booking.");
        }
    }
}

