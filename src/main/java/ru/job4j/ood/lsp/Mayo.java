package ru.job4j.ood.lsp;

import java.time.LocalDate;

public class Mayo extends Food{
    public Mayo(String name, LocalDate createDate, LocalDate expireDate, int price, int discount) {
        super(name, createDate, expireDate, price, discount);
    }
}
