package ru.job4j.ood.lsp.parking;

import java.util.List;

public class Parking {
    private List<Auto> automobiles;
    List<AbstractSlots> separateParkings;

    public Parking(List<Auto> automobiles, List<AbstractSlots> separateParkings) {
        this.automobiles = automobiles;
        this.separateParkings = separateParkings;
    }

    public void park() {
        for (AbstractSlots slot : separateParkings) {
            slot.addToSlot(automobiles);
        }
    }
}