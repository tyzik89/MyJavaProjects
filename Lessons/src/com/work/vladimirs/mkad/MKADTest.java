package com.work.vladimirs.mkad;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MKADTest {

    @Test
    void evaluateDistance() {
        assertEquals(11,   MKAD.evaluateDistance(60, 2));
        assertEquals(108,   MKAD.evaluateDistance(-1, 1));

        assertEquals(109,   MKAD.evaluateDistance(109, 1));
        assertEquals(0,   MKAD.evaluateDistance(-109, 1));

        assertEquals(109,     MKAD.evaluateDistance(109, 1));
        assertEquals(109,     MKAD.evaluateDistance(109, 10));
        assertEquals(0,   MKAD.evaluateDistance(-109, 10));
        assertEquals(47,    MKAD.evaluateDistance(-990, 1000));
    }
}