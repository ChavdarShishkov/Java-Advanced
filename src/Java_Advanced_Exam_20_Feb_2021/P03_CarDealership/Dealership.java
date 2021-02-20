package Java_Advanced_Exam_20_Feb_2021.P03_CarDealership;

import dealership.Car;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Dealership {
    private String name;
    private int capacity;
    List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.data.size() < this.capacity) data.add(car);
    }

    public boolean buy(String manufacturer, String model) {
        return data.removeIf(r -> r.getManufacturer().equals(manufacturer) && r.getModel().equals(model));
    }

    public Car getLatestCar() {
        return this.data.stream().max(Comparator.comparingInt(Car::getYear)).orElse(null);
    }

    public Car getCar(String manufacturer, String model) {
        return this.data.stream().filter(car -> car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)).findFirst().orElse(null);
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder out = new StringBuilder();

        out.append("The cars are in a car dealership ").append(this.name).append(":").append(System.lineSeparator());

        for (Car car : data) {
            out.append(car.toString()).append(System.lineSeparator());
        }
        return out.toString().trim();
    }
}
