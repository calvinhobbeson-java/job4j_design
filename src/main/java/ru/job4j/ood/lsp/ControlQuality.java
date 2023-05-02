package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

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
        for (Food food : foodList) {
            long overallDays = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpireDate());
            long daysBeforeExpire = ChronoUnit.DAYS.between(today, food.getExpireDate());
            long percentage = daysBeforeExpire / overallDays * 100;
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
