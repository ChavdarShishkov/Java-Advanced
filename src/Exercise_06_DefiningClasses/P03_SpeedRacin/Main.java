package Exercise_06_DefiningClasses.P03_SpeedRacin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Car> cars = new ArrayList<>();

        int n = Integer.parseInt(reader.readLine());
        while (n-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");

            String model = tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double fuelCostFor1Km = Double.parseDouble(tokens[2]);


            Car car = new Car(model, fuelAmount, (int) fuelCostFor1Km,0);
            cars.add(car);
        }

        String s = reader.readLine();
        while (!s.equals("End")) {
            String[] tokens = s.split("\\s+");

            String carModel = tokens[1];
            int kmTraveled = Integer.parseInt(tokens[2]);

            s = reader.readLine();
        }
    }
}
