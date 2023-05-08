package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.ListIterator;

public class ControlQuality {
    private List<Food> foodList;
    private List<AbstractStore> stores;
    private LocalDate today;

    public ControlQuality(List<Food> foodList, List<AbstractStore> stores, LocalDate today) {
        this.foodList = foodList;
        this.stores = stores;
        this.today = today;
    }

    public static void setExpireDate(List<Food> foodList, LocalDate today) {
        ListIterator<Food> foodIterator = foodList.listIterator();
        while (foodIterator.hasNext()) {
            Food food = foodIterator.next();
            long overallDays = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpireDate());
            long daysBeforeExpire = ChronoUnit.DAYS.between(today, food.getExpireDate());
            long percentage = 100 - (100 / (overallDays / daysBeforeExpire));
            food.setExpirePercentage((int) percentage);
        }
    }

    public void storesDelivery() {
        setExpireDate(foodList, today);
        for (AbstractStore store : stores) {
            store.addProduct(foodList);
        }
    }
}
