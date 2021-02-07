package Exercise_06_DefiningClasses.P07_Google;

public class Car extends PersonName {
    private String carModel;
    private String carSpeed;

    public Car(String name, String carModel, String carSpeed) {
        super(name);
        this.carModel = carModel;
        this.carSpeed = carSpeed;
    }
}
