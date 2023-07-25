package com.example.reservations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReservationsTest {

    private Restaurant restaurant;
    private Reservations reservations;
    private int initialAvailableTables;

    @BeforeEach
    public void setUp() {
        // Initialize the Restaurant with 3 tables for each test
        restaurant = new Restaurant(3);
        reservations = new Reservations(restaurant);
        initialAvailableTables = reservations.getNumberOfAvailableTables();
    }

    @Test
    public void testNumberOfAvailableTablesEqualsTotal() {
        // Verify that the number of available tables is equal to the total number of tables
        int totalTables = restaurant.getNumberOfTables();
        assertEquals(totalTables, reservations.getNumberOfAvailableTables());
    }

    @Test
    public void testBookingReducesAvailableTablesCount() {
        Table tableToBook = reservations.findAvailableTable();
        assertNotNull(tableToBook);
        try {
            reservations.book("John Doe");
        } catch (Exception e) {
            fail("Booking should not throw an exception.");
        }

        // Check if the number of available tables is updated correctly after booking
        assertEquals(initialAvailableTables - 1, reservations.getNumberOfAvailableTables());
    }

    @Test
    public void testAvailableTablesRemainUnchangedAfterBookingOne() {
        Table tableToBook = reservations.findAvailableTable();
        assertNotNull(tableToBook);
        try {
            reservations.book("John Doe");
        } catch (Exception e) {
            fail("Booking should not throw an exception.");
        }
        Table remainingTable = reservations.findAvailableTable();
        assertNotNull(remainingTable);
    }

    @Test
    public void testBookingAllAvailableTables() {
        // Book all available tables
        for (int i = 0; i < initialAvailableTables; i++) {
            try {
                reservations.book("Guest " + (i + 1));
            } catch (Exception e) {
                fail("Booking should not throw an exception.");
            }
        }

        // Check if the number of available tables is 0 after booking all tables
        assertEquals(0, reservations.getNumberOfAvailableTables());
    }

    @Test
    public void testFindAvailableTableWhenNoTablesAreAvailable() {
        // Book all available tables
        for (int i = 0; i < initialAvailableTables; i++) {
            try {
                reservations.book("Guest " + (i + 1));
            } catch (Exception e) {
                fail("Booking should not throw an exception.");
            }
        }

        Table remainingTable = reservations.findAvailableTable();
        assertNull(remainingTable);
    }

    @Test
    public void testBookingAndVacatingTable() {
        Table tableToBook = reservations.findAvailableTable();
        assertNotNull(tableToBook);
        try {
            reservations.book("John Doe");
        } catch (Exception e) {
            fail("Booking should not throw an exception.");
        }

        // Check if the number of available tables is updated correctly after booking
        assertEquals(initialAvailableTables - 1, reservations.getNumberOfAvailableTables());

        // Vacate the booked table
        tableToBook.vacate();

        // Check if the number of available tables is restored to the initial value after vacating
        assertEquals(initialAvailableTables, reservations.getNumberOfAvailableTables());
    }

    @Test
    public void testBookingWhenNoTablesAreAvailable() {
        // Book all remaining tables
        for (int i = 0; i < initialAvailableTables; i++) {
            try {
                reservations.book("Guest " + (i + 1));
            } catch (Exception e) {
                fail("Booking should not throw an exception.");
            }
        }

        assertEquals(0, reservations.getNumberOfAvailableTables());

        // Try to book when no tables are available (should throw an exception)
        try {
            reservations.book("Bob");
            fail("Booking should throw an exception when no tables are available.");
        } catch (Exception e) {
            assertEquals("No available tables.", e.getMessage());
        }
    }
}
