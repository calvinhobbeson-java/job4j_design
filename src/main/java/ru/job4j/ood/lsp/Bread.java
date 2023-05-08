package ru.job4j.ood.lsp;

import java.time.LocalDate;

public class Bread extends Food{
    public Bread(String name, LocalDate createDate, LocalDate expireDate, int price, int discount) {
        super(name, createDate, expireDate, price, discount);
    }
}
