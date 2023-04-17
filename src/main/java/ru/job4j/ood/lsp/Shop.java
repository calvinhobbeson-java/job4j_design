package ru.job4j.ood.lsp;

import java.util.List;

public class Shop extends AbstractStore {
    private List<Food> storage;
    private int discount;

    @Override
    public void addProduct(List<Food> foodList) {
        for (Food food : foodList) {
            if (food.getExpirePercentage() <= 75 && food.getExpirePercentage() >= 25) {
                food.setDiscount(discount);
                storage.add(food);
                foodList.remove(food);
            }
        }
    }

    public List<Food> getStorage() {
        return storage;
    }
}
