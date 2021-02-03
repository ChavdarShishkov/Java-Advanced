package Exercise_06_DefiningClasses.P04_RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Set<Tyres> cars = new LinkedHashSet<>();

        int n = Integer.parseInt(reader.readLine());
        String cargo;

        while (n-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");

            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            double tyre1Pressure = Double.parseDouble(tokens[5]);
            int tyre1Age = Integer.parseInt(tokens[6]);
            double tyre2Pressure = Double.parseDouble(tokens[7]);
            int tyre2Age = Integer.parseInt(tokens[8]);
            double tyre3Pressure = Double.parseDouble(tokens[9]);
            int tyre3Age = Integer.parseInt(tokens[10]);
            double tyre4Pressure = Double.parseDouble(tokens[11]);
            int tyre4Age = Integer.parseInt(tokens[12]);

            Tyres tyres = new Tyres(model, engineSpeed, enginePower, cargoWeight, cargoType, tyre1Pressure, tyre1Age,
                    tyre2Pressure, tyre2Age, tyre3Pressure, tyre3Age, tyre4Pressure, tyre4Age);

            cars.add(tyres);

            cargo = reader.readLine();

        }
        System.out.println(cars);
    }
}
