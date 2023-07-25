package com.example.reservations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TableTest {

    @Test
    void newTableShouldBeAvailable() {
        var table = new Table();
        assertEquals(true, table.isAvailable());
    }

    @Test
    void bookingTableShouldMakeItUnavailable() {
        var table = new Table();
        table.bookFor("Pinco Pallo");
        assertEquals(false, table.isAvailable());
    }

    @Test
    void vacatingTableShouldMakeItAvailableAgain() {
        var table = new Table();
        table.bookFor("Pinco Pallo");
        table.vacate();
        assertEquals(true, table.isAvailable());
    }

    @Test
    void bookedTableShouldHaveCorrectNominative() {
        var table = new Table();
        String guestName = "Pinco Pallo";
        table.bookFor(guestName);
        assertEquals(guestName, table.getNominative());
    }

    @Test
    void vacatedTableShouldHaveEmptyNominative() {
        var table = new Table();
        String guestName = "Pinco Pallo";
        table.bookFor(guestName);
        table.vacate();
        assertNull(table.getNominative());
    }
}