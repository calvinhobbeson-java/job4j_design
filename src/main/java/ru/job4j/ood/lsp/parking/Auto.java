package ru.job4j.ood.lsp.parking;

public abstract class Auto implements Car, Truck {
    int size;
    public Auto(int size)  {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
