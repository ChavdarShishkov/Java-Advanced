package Exercise_06_DefiningClasses.P04_RawData;

public class Cargo extends Engine {
    private int cargoWeight;
    private String cargoType;

    public Cargo(String model, int engineSpeed, int enginePower, int cargoWeight, String cargoType) {
        super(model, engineSpeed, enginePower);
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
    }
}
