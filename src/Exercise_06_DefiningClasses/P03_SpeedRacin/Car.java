package Exercise_06_DefiningClasses.P03_SpeedRacin;

public class Car {
    private String model;
    private int fuelAmount;
    private double fuelCostFor1Km;
    private int distanceTraveled;

    public Car(String model, int fuelAmount, double fuelCostFor1Km) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostFor1Km = fuelCostFor1Km;
        distanceTraveled = 0;
    }

    public String getModel() {
        return model;
    }

    public int getFuelAmount() {
        return fuelAmount;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public void Drive(int distance) {
        if (distance * this.fuelCostFor1Km <= this.fuelAmount) {
            this.distanceTraveled += distance;
            this.fuelAmount -= distance * this.fuelAmount;
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }
}
