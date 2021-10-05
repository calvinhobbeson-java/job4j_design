package ru.job4j.map;

import java.util.Iterator;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if (count >= LOAD_FACTOR * capacity) {
            expand();
        }
        int index = indexFor(hash(key));

        if (table[index] != null) {
            return false;
        } else {
            table[index].key = key;
            table[index].value = value;
            count++;
            modCount++;
            return true;
        }
    }

    private int hash(Object key) {
        int h = key.hashCode();
        return (key == null) ? 0 : (h) ^ (h >>> 16);
    }

    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    private void expand() {
        count = 0;
        MapEntry<K, V>[] temp = table;
        table = new MapEntry[capacity * 2];
        for (MapEntry<K, V> entry : temp) {
          put(entry.key, entry.value);
    }
}

    @Override
    public V get(K key) {
        int index = indexFor(hash(key));
        if (table[index] == null) {
            return null;
        }
        return table[index].value;
    }

    @Override
    public boolean remove(K key) {
        int index = indexFor(hash(key));
        if (table[index].key.equals(key)) {
            table[index].key = null;
            count--;
            modCount++;
            return true;
        }
        return false;
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

}