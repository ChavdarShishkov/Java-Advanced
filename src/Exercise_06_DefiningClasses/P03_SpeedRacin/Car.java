package Exercise_06_DefiningClasses.P03_SpeedRacin;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostFor1Km;
    private int distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCostFor1Km, int distanceTraveled) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostFor1Km = fuelCostFor1Km;
        this.distanceTraveled = 0;
    }

    public Car(int distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelCostFor1Km() {
        return fuelCostFor1Km;
    }

    public void setFuelCostFor1Km(double fuelCostFor1Km) {
        this.fuelCostFor1Km = fuelCostFor1Km;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(int distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d%n", getModel(), getFuelAmount(), getDistanceTraveled());
    }
}
