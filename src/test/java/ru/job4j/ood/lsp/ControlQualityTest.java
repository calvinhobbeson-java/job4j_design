package ru.job4j.ood.lsp;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import static org.junit.Assert.assertFalse;

class ControlQualityTest {

    @Test
    public void whenStart() {
        int discount = 15;
        Noodles noodles = new Noodles("JinRamen", LocalDate.now().minusMonths(1), LocalDate.now().plusMonths(3), 49, discount, 0);
        Bread bread = new Bread("WhiteBread", LocalDate.now().minusDays(10), LocalDate.now().plusDays(11), 20, discount, 0);
        Mayo mayo = new Mayo("Provansal", LocalDate.now().minusMonths(1), LocalDate.now().plusMonths(10), 50, discount, 0);
        Mayo mayoTwo = new Mayo("Calve Light", LocalDate.now().minusMonths(20), LocalDate.now().plusMonths(19), 60, discount, 0);
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        ControlQuality controlQuality = new ControlQuality(List.of(noodles, bread, mayo, mayoTwo), List.of(warehouse, shop, trash));
        controlQuality.storesDelivery();
        assertFalse(shop.getStorage().isEmpty());
    }
}