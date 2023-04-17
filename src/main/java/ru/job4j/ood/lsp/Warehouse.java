package ru.job4j.ood.lsp;

import java.util.List;

public class Warehouse extends AbstractStore {
    private List<Food> storage;

    @Override
    public void addProduct(List<Food> foodList) {
        for (Food food : foodList) {
            if (food.getExpirePercentage() >= 75) {
                storage.add(food);
                foodList.remove(food);
            }
        }
    }
}
