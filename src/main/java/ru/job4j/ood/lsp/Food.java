package ru.job4j.ood.lsp;

import java.time.LocalDate;

public abstract class Food {
    private String name;
    private LocalDate createDate;
    private LocalDate expireDate;
    private int price;
    private int discount;
    private int expirePercentage;

    public Food(String name, LocalDate createDate, LocalDate expireDate, int price, int discount) {
        this.name = name;
        this.createDate = createDate;
        this.expireDate = expireDate;
        this.price = price;
        this.discount = discount;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getExpirePercentage() {
        return expirePercentage;
    }
    public void setExpirePercentage(int expirePercentage) {
        this.expirePercentage = expirePercentage;
    }
}
