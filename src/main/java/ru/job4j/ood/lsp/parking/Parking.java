package ru.job4j.ood.lsp.parking;

import java.util.List;

public interface Parking {

    boolean add(Auto auto);
    List<Auto> getCarParking();
    List<Auto> getTruckParking();
}