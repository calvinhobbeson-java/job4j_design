package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Warehouse extends AbstractStore {
    private List<Food> storage = new ArrayList<>();

    @Override
    public void addProduct(List<Food> foodList) {
        ListIterator<Food> foodIterator = foodList.listIterator();
        Food food = foodIterator.next();
        while (foodIterator.hasNext()) {
            if (food.getExpirePercentage() >= 75) {
                storage.add(food);
                foodList.remove(food);
            }
        }
    }
    public List<Food> getStorage() {
        return storage;
    }
}
