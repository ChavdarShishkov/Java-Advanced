package Exercise_06_DefiningClasses.P09_CatLady;

public class Siamese extends Cat {
    private double earSize;

    public Siamese(String name, String type, double earSize) {
        super(name, type);
        this.earSize = earSize;
    }

    public void setEarSize(double earSize) {
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%.2f", this.earSize);
    }
}
