package homeworks.homework11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        String title = "";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(
                "src/homeworks/homework11/input.txt"))) {

            title = bufferedReader.readLine();
            String[] readData;
            String str = "";

            while (str != null) {
                str = bufferedReader.readLine();
                if (str != null) {
                    readData = str.split("\\|");

                    cars.add(new Car(readData[0], readData[1], readData[2],
                            Integer.parseInt(readData[3]), Integer.parseInt(readData[4])));
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\nАвтомобили в базе:\n" + title);

        for (Car c : cars) {
            System.out.println(c.toString());
        }

        String getCarByColorWithMinCost = cars.stream()
                .min(Comparator.comparingInt(Car::getCost))
                .map(Car::getColor)
                .get();

        System.out.println("\nЦвет автомобиля с минимальной стоимостью: "
                + getCarByColorWithMinCost);

        String modelToFind = "Toyota";

        Double getAverageCostByCarModel = cars.stream()
                .filter(e -> e.getModel().equals(modelToFind))
                .mapToDouble(Car::getCost)
                .average()
                .getAsDouble();

        System.out.println("\nСредняя стоимость модели " + modelToFind + " "
                + getAverageCostByCarModel);
    }
}
