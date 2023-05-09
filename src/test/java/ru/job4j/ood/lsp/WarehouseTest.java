package ru.job4j.ood.lsp;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class WarehouseTest {

    @Test
    void whenAddProduct() {
            int discount = 15;
            Noodles noodles = new Noodles("JinRamen", LocalDate.now().minusMonths(1), LocalDate.now().plusMonths(20), 49, discount);
            Bread bread = new Bread("WhiteBread", LocalDate.now().minusDays(10), LocalDate.now().plusDays(1), 20, discount);
        Warehouse warehouse = new Warehouse();
            ControlQuality controlQuality = new ControlQuality(new ArrayList<>(List.of(noodles, bread)), List.of(warehouse),LocalDate.now());
            controlQuality.storesDelivery();
        assertThat(warehouse.getStorage().contains(noodles)).isTrue();
        }
    }