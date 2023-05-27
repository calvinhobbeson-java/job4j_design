package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class FirstParking implements Parking {
    int carParkingSize;
    int truckParkingSize;

    List<Auto> carParking = new ArrayList<>();
    List<Auto> truckParking = new ArrayList<>();

    public FirstParking(int carParkingSize, int truckParkingSize) {
        this.carParkingSize = carParkingSize;
        this.truckParkingSize = truckParkingSize;
    }


    public boolean add(Auto auto) {
        boolean rsl = false;
        if (truckParkingSize >= Car.SIZE && auto.getSize() > Car.SIZE) {
            truckParking.add(auto);
            truckParkingSize--;
            rsl = true;
        } else if (carParkingSize >= auto.getSize()) {
            carParking.add(auto);
            carParkingSize -= auto.getSize();
            rsl = true;
        }
        return rsl;
    }

    public List<Auto> getCarParking() {
        return carParking;
    }

    public List<Auto> getTruckParking() {
        return truckParking;
    }
}
