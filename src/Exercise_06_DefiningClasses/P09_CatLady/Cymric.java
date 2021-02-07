package Exercise_06_DefiningClasses.P09_CatLady;

public class Cymric extends Cat {
    private double furLength;

    public Cymric(String name, String type, double furLength) {
        super(name, type);
        this.furLength = furLength;
    }

    public double getFurLength() {
        return furLength;
    }
    @Override
    public String toString() {
        return super.toString() + String.format("%.2f", this.furLength);
    }
}
