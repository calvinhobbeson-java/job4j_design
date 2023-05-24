package ru.job4j.ood.lsp;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.parking.*;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@Disabled
class ParkingTest {
    @Test
    public void whenStart()  {
        CarSlots carslots = new CarSlots();
        TruckSlots truckSlots = new TruckSlots();
        carslots.setSlots(new ArrayList<>(2));
        truckSlots.setSlots(new ArrayList<>(2));
        Auto toyota = new Toyota(1);
        Auto moskvitch = new Moskvitch(1);
        Auto kamaz = new Kamaz(2);
        Parking parking = new Parking(new ArrayList<>(List.of(toyota, moskvitch, kamaz)), new ArrayList<>(List.of(carslots, truckSlots)));
        parking.park();
        List<Auto> expected = List.of(toyota, moskvitch);
        assertThat(carslots.getSlots().equals(expected));
    }
}
