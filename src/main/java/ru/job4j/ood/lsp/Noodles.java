package ru.job4j.ood.lsp;

import java.time.LocalDate;

public class Noodles extends Food {
    public Noodles(String name, LocalDate createDate, LocalDate expireDate, int price, int discount, int expirePercentage) {
        super(name, createDate, expireDate, price, discount, expirePercentage);
    }
}
