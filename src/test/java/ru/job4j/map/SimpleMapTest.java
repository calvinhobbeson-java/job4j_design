package ru.job4j.map;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class SimpleMapTest {

    @Test
    public void ifEqualsThenSame() {
        SimpleMap<Integer, Integer> simpleMap = new SimpleMap<>();
        assertTrue(simpleMap.put(10, 10));
        assertFalse(simpleMap.put(10, 10));
    }

    @Test
    public void ifPutDifferentThenOk() {
        SimpleMap<Integer, Integer> simpleMap = new SimpleMap<>();
        assertTrue(simpleMap.put(1, 1));
        assertTrue(simpleMap.put(2, 2));
        assertTrue(simpleMap.put(3, 3));
    }

    @Test
    public void ifPutThenGet() {
        SimpleMap<Integer, Integer> simpleMap = new SimpleMap<>();
        simpleMap.put(1, 100);
        assertThat(simpleMap.get(1), is(100));
    }

    @Test
    public void ifGetNullThenNull() {
        SimpleMap<Integer, Integer> simpleMap = new SimpleMap<>();
        simpleMap.put(1, 100);
        simpleMap.remove(1);
        assertThat(simpleMap.get(1), is(nullValue()));
    }

    @Test
    public void ifRemoveFirstThenNull() {
        SimpleMap<Integer, Integer> simpleMap = new SimpleMap<>();
        simpleMap.put(1, 100);
        simpleMap.remove(1);
        assertThat(simpleMap.get(1), is(nullValue()));
    }

    @Test
    public void whenInsertThenDelete() {
        SimpleMap<Integer, Integer> table = new SimpleMap<>();
        table.put(1, 1);
        assertThat(table.get(1), is(1));
        assertTrue(table.remove(1));
        assertNull(table.get(1));
    }
}