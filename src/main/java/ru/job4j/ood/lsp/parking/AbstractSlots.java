package ru.job4j.ood.lsp.parking;

import java.util.List;

public abstract class AbstractSlots {
    private List<Auto> slots;

    public AbstractSlots(List<Auto> slots) {
        this.slots = slots;
    }

    public abstract void addToSlot(List<Auto> autoList);
}
