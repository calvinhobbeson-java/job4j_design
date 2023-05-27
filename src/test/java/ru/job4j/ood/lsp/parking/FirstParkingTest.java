package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class FirstParkingTest {

    @Test
    void whenStart() {
        Auto truck = new Truck("Kamaz", 2);
        Parking parking = new FirstParking(0, 2);
        parking.add(truck);
        assertThat(parking.getTruckParking()).isEqualTo(List.of(truck));
    }

    @Test
    void whenStart2() {
        Auto car = new Car("Moskvich");
        Parking parking = new FirstParking(1, 0);
        parking.add(car);
        assertThat(parking.getCarParking()).isEqualTo(List.of(car));
    }

    @Test
    void whenStart3() {
        Auto truck = new Truck("Kamaz", 2);
        Parking parking = new FirstParking(2, 0);
        parking.add(truck);
        assertThat(parking.getCarParking()).isEqualTo(List.of(truck));
    }
}