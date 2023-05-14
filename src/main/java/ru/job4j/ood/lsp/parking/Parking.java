package ru.job4j.ood.lsp.parking;

import java.util.List;

public class Parking {
    private List<Auto> cars;
    private List<Auto> trucks;
   private List<Auto> autoList;

    public Parking(List<Auto> cars, List<Auto> trucks, List<Auto> autoList) {
        this.cars = cars;
        this.trucks  = trucks;
        this.autoList = autoList;
    }
    public void park()  {
    }

    public List<Auto> getCars() {
        return cars;
    }

    public void setCars(List<Auto> cars) {
        this.cars = cars;
    }
}
