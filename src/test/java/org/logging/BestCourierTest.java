package org.logging;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class BestCourierTest {

    @Test
    @DisplayName("Selecting the cheapest courier with refrigeration")
    public void shouldReturnGeoff() throws Exception {
        BestCourier bestCourier = new BestCourier();
        bestCourier.selectCourier("15:00", 3.5, true);
        assertEquals("Geoff", bestCourier.getCheapest().getName());
    }

    @Test
    @DisplayName("Selecting the courier with max distance")
    public void shouldReturnBobby() throws Exception {
        BestCourier bestCourier = new BestCourier();
        bestCourier.selectCourier("12:50", 5, true);
        assertEquals("Bobby", bestCourier.getCheapest().getName());
    }

    @Test
    @DisplayName("Selecting the cheapest courier, refrigeration not needed")
    public void shouldReturnMartin() throws Exception {
        BestCourier bestCourier = new BestCourier();
        bestCourier.selectCourier("16:59", 3, false);
        assertEquals("Martin", bestCourier.getCheapest().getName());
    }

    @Test
    @DisplayName("Selecting the cheapest courier, with or without refrigeration")
    public void shouldReturnBobbyWithRefrigeration() throws Exception {
        BestCourier bestCourier = new BestCourier();
        bestCourier.selectCourier("11:59", 3.5, false);
        assertEquals("Bobby", bestCourier.getCheapest().getName());
    }

    @Test
    @DisplayName("Selecting courier with out of bound criteria")
    public void shouldThrowException() throws Exception {
        BestCourier bestCourier = new BestCourier();

        assertThrows(NullPointerException.class, (Executable) bestCourier.selectCourier("17:20", 3, false));

    }

}