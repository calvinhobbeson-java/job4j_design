package ru.job4j.ood.lsp;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class TrashTest {
    @Test
    void whenAddProduct() {
        int discount = 15;
        Noodles noodles = new Noodles("JinRamen", LocalDate.now().minusMonths(50), LocalDate.now().plusMonths(1), 49, discount);
        Bread bread = new Bread("WhiteBread", LocalDate.now().minusDays(10), LocalDate.now().plusDays(0), 20, discount);
        Trash  trash = new Trash();
        ControlQuality controlQuality = new ControlQuality(new ArrayList<>(List.of(noodles, bread)), List.of(trash),LocalDate.now());
        List<Food> expected = List.of(bread);
        assertThat(trash.getStorage(), isEqualTo(expected));
    }
}