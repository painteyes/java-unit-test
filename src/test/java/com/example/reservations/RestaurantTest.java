package com.example.reservations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RestaurantTest {

    private Restaurant restaurant;
    private int initialNumberOfTables;

    @BeforeEach
    public void setUp() {
        // Initialize the Restaurant with a variable number of tables for each test
        initialNumberOfTables = 3;
        restaurant = new Restaurant(initialNumberOfTables);
    }

    @Test
    public void testGetNumberOfTables() {
        // Test getting the number of tables initially set in the constructor
        assertEquals(initialNumberOfTables, restaurant.getNumberOfTables());
    }

    @Test
    public void testAddTable() {
        // Test adding a table
        restaurant.addTable(new Table());
        assertEquals(initialNumberOfTables + 1, restaurant.getNumberOfTables());

        // Test adding multiple tables
        restaurant.addTable(new Table());
        restaurant.addTable(new Table());
        assertEquals(initialNumberOfTables + 3, restaurant.getNumberOfTables());

        // Reset the number of tables after adding tables
        restaurant.initializeTables(initialNumberOfTables);
    }

    @Test
    public void testRemoveTable() {
        // Add some tables first
        Table table1 = new Table();
        Table table2 = new Table();
        restaurant.addTable(table1);
        restaurant.addTable(table2);

        // Test removing a table that exists
        restaurant.removeTable(table1);
        assertEquals(initialNumberOfTables + 1, restaurant.getNumberOfTables());

        // Test removing a table that doesn't exist (should not change the number of tables)
        Table table3 = new Table();
        restaurant.removeTable(table3);
        assertEquals(initialNumberOfTables + 1, restaurant.getNumberOfTables());

        // Test removing the first two tables added
        restaurant.removeTable(restaurant.getTables().get(0));
        restaurant.removeTable(restaurant.getTables().get(0));
        assertEquals(initialNumberOfTables - 1, restaurant.getNumberOfTables());

        // Reset the number of tables after removing tables
        restaurant.initializeTables(initialNumberOfTables);
    }
}
