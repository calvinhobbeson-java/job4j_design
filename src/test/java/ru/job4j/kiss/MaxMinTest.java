package ru.job4j.kiss;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class MaxMinTest {

    private List<Integer> values;
    private Comparator<Integer> comparator;

    @BeforeEach
    void init() {
        values = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        comparator = Comparator.naturalOrder();
    }

    @Test
    public void whenMin()  {
        MaxMin testMin = new MaxMin();
        assertTrue(testMin.min(values, comparator).equals(1));
    }

    @Test
    public void whenMax()  {
        MaxMin testMin = new MaxMin();
        assertTrue(testMin.max(values, comparator).equals(6));
    }

}