package ru.job4j.ood.lsp;

import java.util.List;

public abstract class AbstractStore {
    private List<Food> storage;

    public abstract void addProduct(List<Food> foodList);
}
