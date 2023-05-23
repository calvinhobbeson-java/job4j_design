package ru.job4j.ood.lsp.parking;

import java.util.List;
import java.util.ListIterator;

public class TruckSlots extends AbstractSlots {
    private List<Auto> slots;
    private int availableSlots = slots.size();

    public TruckSlots(List<Auto> slots) {
        super(slots);
    }

    @Override
    public void addToSlot(List<Auto> autoList) {
        ListIterator<Auto> autoListIterator = autoList.listIterator();
        Auto auto = autoListIterator.next();
        int counter;
        while (autoListIterator.hasNext() && availableSlots > 0) {
            counter = autoListIterator.next().getSize();
            if (counter > 0) {
                slots.add(auto);
                counter--;
                availableSlots--;
            }
            autoListIterator.remove();
        }
    }
}
