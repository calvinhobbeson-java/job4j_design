package ru.job4j.kiss;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MaxMinTest {

    private List<Integer> values;
    private Comparator<Integer> comparator;

    @BeforeEach
    void init() {
        values = List.of(1, 20, 3, 4, -5, 6);
        comparator = Comparator.naturalOrder();
    }

    @Test
    public void whenMin()  {
        MaxMin testMin = new MaxMin();
        assertTrue(testMin.min(values, comparator).equals(-5));
    }

    @Test
    public void whenMax()  {
        MaxMin testMin = new MaxMin();
        assertTrue(testMin.max(values, comparator).equals(20));
    }

}