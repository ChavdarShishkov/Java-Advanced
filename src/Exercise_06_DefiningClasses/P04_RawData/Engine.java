package Exercise_06_DefiningClasses.P04_RawData;

public class Engine extends Model {
    private int engineSpeed;
    private int enginePower;

    public Engine(String model, int engineSpeed, int enginePower) {
        super(model);
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
    }
}
