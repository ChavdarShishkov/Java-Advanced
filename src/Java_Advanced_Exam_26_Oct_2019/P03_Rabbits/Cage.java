package Java_Advanced_Exam_26_Oct_2019.P03_Rabbits;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Rabbit rabbit) {
        if (this.data.size() < capacity) data.add(rabbit);
    }

    public void removeRabbit(String name) {
        data.removeIf(r -> r.getName().equals(name));
    }

    public void removeSpecies(String species) {
        this.data.removeIf(r -> r.getSpecies().equals(species));
    }

    public Rabbit sellRabbit(String name) {
        Rabbit rabbitToReturn = null;

        for (Rabbit rabbit : data) {
            if (rabbit.getName().equals(name)) {
                rabbitToReturn = rabbit;
                rabbit.setAvailable();
                break;
            }
        }
        return rabbitToReturn;
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {

        List<Rabbit> soldRabbits =
                data.stream().filter(r -> r.getSpecies().equals(species)).collect(Collectors.toList());

        data.removeIf(x -> x.getSpecies().equals(species));

        return soldRabbits;
    }

    public int count() {
        return data.size();
    }

    public String report() {

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Rabbits available at %s:%n", this.getName()));

        for (Rabbit rabbit : data) {

            if (rabbit.isAvailable()) sb.append(rabbit).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
