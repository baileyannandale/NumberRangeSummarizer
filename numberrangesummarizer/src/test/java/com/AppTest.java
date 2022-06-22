package com;

import java.util.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     */

    private NumberRangeSummarizerGen numberRangeSummarizerGen = new NumberRangeSummarizerGen();

    /**
     * Test to check that the Collection is non-empty
     * This assumes that the input is a fixed string.
     */
    @Test
    public void testNonEmpty() {
        Collection<Integer> numbers = numberRangeSummarizerGen.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
        assertEquals(numbers.isEmpty(), false);
    }

    /**
     * Test to check that the numbers are sequential to get the correct summarized range.
     * This assumes that the input is a fixed string.
     */
    @Test
    public void testCollectionSequential() {
        Collection<Integer> numbers = numberRangeSummarizerGen.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
        ArrayList<Integer> list = new ArrayList<>(numbers);
        boolean check = true;
        for (int i = 0; i < list.size(); i++) {
            if (i + 1 == list.size()) {
                break;
            }
            if (list.get(i) < list.get(i + 1)) {
                check = true;
            } else {
                check = false;
                break;
            }
        }
        assertEquals(check, true);
    }

    /**
     * Test to check that the numbers match the expected output.
     * This assumes that the input is a fixed string.
     */
    @Test
    public void testNumbersSummarized() {
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        String expectedSummary = "1,3,6-8,12-15,21-24,31";
        Collection<Integer> numbers = numberRangeSummarizerGen.collect(input);
        assertEquals(numberRangeSummarizerGen.summarizeCollection(numbers), expectedSummary);
    }
}
