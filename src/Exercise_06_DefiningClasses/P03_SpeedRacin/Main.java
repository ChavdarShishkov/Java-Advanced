package Exercise_06_DefiningClasses.P03_SpeedRacin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Set<Car> cars = new LinkedHashSet<>();
        Set<Car> modelDistanceTraveled = new LinkedHashSet<>();


        int n = Integer.parseInt(reader.readLine());
        while (n-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");

            String model = tokens[0];
            int fuelAmount = Integer.parseInt(tokens[1]);
            double fuelCostFor1Km = Double.parseDouble(tokens[2]);


            Car car = new Car(model, fuelAmount, fuelCostFor1Km, 0);
            cars.add(car);
        }

        String s = reader.readLine();
        while (!s.equals("End")) {
            String[] tokens = s.split("\\s+");

            String carModel = tokens[1];
            int kmTraveled = Integer.parseInt(tokens[2]);
            Car car = new Car(carModel, kmTraveled);
            s = reader.readLine();
            modelDistanceTraveled.add(car);
        }

    }
}
