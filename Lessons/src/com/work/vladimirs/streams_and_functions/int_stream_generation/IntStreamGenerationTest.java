package com.work.vladimirs.streams_and_functions.int_stream_generation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

class IntStreamGenerationTest {

    @Test
    void pseudoRandomStream() {
        IntStreamGeneration intStreamGeneration = new IntStreamGeneration();

        assertEquals(
                "[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]",
                Arrays.toString(intStreamGeneration.pseudoRandomStream(0, 20).toArray()));
        assertEquals(
                "[1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]",
                Arrays.toString(intStreamGeneration.pseudoRandomStream(1, 20).toArray()));
        assertEquals(
                "[2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]",
                Arrays.toString(intStreamGeneration.pseudoRandomStream(2, 20).toArray()));
        assertEquals(
                "[3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]",
                Arrays.toString(intStreamGeneration.pseudoRandomStream(3, 20).toArray()));
        assertEquals(
                "[4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]",
                Arrays.toString(intStreamGeneration.pseudoRandomStream(4, 20).toArray()));
        assertEquals(
                "[5, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]",
                Arrays.toString(intStreamGeneration.pseudoRandomStream(5, 20).toArray()));
        assertEquals(
                "[6, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]",
                Arrays.toString(intStreamGeneration.pseudoRandomStream(6, 20).toArray()));
        assertEquals(
                "[7, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]",
                Arrays.toString(intStreamGeneration.pseudoRandomStream(7, 20).toArray()));
        assertEquals(
                "[8, 6, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]",
                Arrays.toString(intStreamGeneration.pseudoRandomStream(8, 20).toArray()));
        assertEquals(
                "[9, 8, 6, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]",
                Arrays.toString(intStreamGeneration.pseudoRandomStream(9, 20).toArray()));
        assertEquals(
                "[10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10]",
                Arrays.toString(intStreamGeneration.pseudoRandomStream(10, 20).toArray()));
        assertEquals(
                "[11, 12, 14, 19, 36, 129, 664, 89, 792, 726, 707, 984, 825, 62, 384, 745, 502, 200, 0, 0]",
                Arrays.toString(intStreamGeneration.pseudoRandomStream(11, 20).toArray()));
        assertEquals(
                "[12, 14, 19, 36, 129, 664, 89, 792, 726, 707, 984, 825, 62, 384, 745, 502, 200, 0, 0, 0]",
                Arrays.toString(intStreamGeneration.pseudoRandomStream(12, 20).toArray()));
        assertEquals(
                "[13, 16, 25, 62, 384, 745, 502, 200, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]",
                Arrays.toString(intStreamGeneration.pseudoRandomStream(13, 20).toArray()));
    }
}