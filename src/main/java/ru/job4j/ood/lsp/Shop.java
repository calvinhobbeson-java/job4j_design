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
            Food food = foodIterator.next();
            if (food.getExpirePercentage() >= 75 && food.getExpirePercentage() <= 25) {
                food.setDiscount(discount);
                storage.add(food);
                foodIterator.remove();
            }
        }
    }

    public List<Food> getStorage() {
        return storage;
    }
}
