package ru.job4j.ood.lsp;

import java.time.LocalDateTime;
import java.util.List;

public class Trash extends AbstractStore {
    private List<Food> storage;

    @Override
    public void addProduct(List<Food> foodList) {
        for (Food food : foodList) {
            if (food.getExpirePercentage() <= 75) {
                storage.add(food);
                foodList.remove(food);
            }
        }
    }
}
