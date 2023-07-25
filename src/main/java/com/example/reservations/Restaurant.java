package com.example.reservations;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private final List<Table> tableList;

    public Restaurant(int numberOfTables) {
        tableList = new ArrayList<>();
        initializeTables(numberOfTables);
    }

    public void initializeTables(int numberOfTables) {
        tableList.clear();
        for (int i = 0; i < numberOfTables; i++) {
            tableList.add(new Table());
        }
    }

    public void addTable(Table table) { tableList.add(table); }

    public void removeTable(Table table) {
        tableList.remove(table);
    }

    public int getNumberOfTables() {
        return tableList.size();
    }

    public List<Table> getTables() { return new ArrayList<>(tableList); }
}
