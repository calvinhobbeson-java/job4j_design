package ru.job4j.ood.lsp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Trash extends AbstractStore {
    private List<Food> storage = new ArrayList<>();

    @Override
    public void addProduct(List<Food> foodList) {
        ListIterator<Food> foodIterator = foodList.listIterator();
        while (foodIterator.hasNext()) {
            if (foodIterator.next().getExpirePercentage() <= 75) {
                storage.add(foodIterator.next());
                foodList.remove(foodIterator.next());
            }
        }
    }
    public List<Food> getStorage() {
        return storage;
    }
}
