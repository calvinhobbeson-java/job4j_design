package ru.job4j.ood.lsp.parking;

import java.util.List;

public abstract class AbstractSlots {
    private List<Auto> slots;
    private int availableSlots;

    public AbstractSlots(List<Auto> slots, int availableSlots) {
        this.slots = slots;
        this.availableSlots = availableSlots;
    }

    public abstract void addToSlot(List<Auto> autoList);
}
