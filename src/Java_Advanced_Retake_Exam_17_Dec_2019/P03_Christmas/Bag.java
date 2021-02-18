package Java_Advanced_Retake_Exam_17_Dec_2019.P03_Christmas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bag {

    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String colour, int capacity) {
        this.color = colour;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return this.data.size();
    }

    public void add(Present present) {
        if (this.data.size() < this.capacity) data.add(present);
    }

    public void remove(String name) {
        data.removeIf(r -> r.getName().equals(name));
    }

    public Present heaviestPresent() {
        return this.data.stream().max(Comparator.comparingDouble(Present::getWeight)).orElse(null);
    }

    public Present getPresent(String present) {
        Present getPresent = null;

        for (Present present1 : data) {
            if (present1.getName().equals(present)) {
                getPresent = present1;
                break;
            }
        }
        return getPresent;
    }

    public String report() {
        StringBuilder out = new StringBuilder();

        out.append(this.getColor()).append(" bag contains:").append(System.lineSeparator());

        for (Present present : data) {
            out.append(present.toString()).append(System.lineSeparator());
        }
        return out.toString().trim();
    }
}
