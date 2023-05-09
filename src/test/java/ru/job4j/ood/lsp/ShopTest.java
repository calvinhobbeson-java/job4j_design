package ru.job4j.ood.lsp;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class ShopTest {

    @Test
    void whenAddProduct() {
        int discount = 15;
        Noodles noodles = new Noodles("JinRamen", LocalDate.now().minusMonths(50), LocalDate.now().plusMonths(1), 49, discount);
        Bread bread = new Bread("WhiteBread", LocalDate.now().minusDays(10), LocalDate.now().plusDays(11), 20, discount);
        Shop shop = new Shop();
        ControlQuality controlQuality = new ControlQuality(new ArrayList<>(List.of(bread, noodles)), List.of(shop),LocalDate.now());
        controlQuality.storesDelivery();
        assertThat(shop.getStorage().contains(bread)).isTrue();
    }
}