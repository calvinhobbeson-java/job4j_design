package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Shop extends AbstractStore {
    private List<Food> storage = new ArrayList<>();
    private int discount = 0;

    @Override
    public void addProduct(List<Food> foodList) {
        ListIterator<Food> foodIterator = foodList.listIterator();
        while (foodIterator.hasNext()) {
            if (foodIterator.next().getExpirePercentage() <= 75 && foodIterator.next().getExpirePercentage() >= 25) {
                foodIterator.next().setDiscount(discount);
                storage.add(foodIterator.next());
                foodList.remove(foodIterator.next());
            }
        }
    }

    public List<Food> getStorage() {
        return storage;
    }
}
