package ru.job4j.ood.lsp.parking;

public abstract class Auto {
    int size;
    String name;

    public Auto(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }
}