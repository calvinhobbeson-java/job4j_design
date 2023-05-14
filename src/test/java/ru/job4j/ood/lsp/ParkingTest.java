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
        int carParkingSize = 2;
        int truckParkingSize = 1;
        List<Auto> cars = new ArrayList<>(carParkingSize);
        List<Auto> trucks = new ArrayList<>(truckParkingSize);
        Auto toyota = new Toyota();
        Auto moskvitch = new Moskvitch();
        Auto kamaz = new Kamaz();
        Parking parking = new Parking(cars, trucks, new ArrayList<>(List.of(toyota, moskvitch, kamaz)));
        parking.park();
        List<Auto> expected = List.of(toyota, moskvitch);
        assertThat(parking.getCars().equals(expected));
    }
}
