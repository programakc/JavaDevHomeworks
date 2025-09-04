package homeworks.homework09;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        String winner;
        Garage garage = new Garage();
        Car[] arrayCar = new Car[3];

        arrayCar[0] = new PerformanceCar("Nissan", "Z (RZ34)", 2025, 400, 4, 30,
                14, new String[0]);
        arrayCar[1] = new ShowCar("McLaren", "750S", 2025, 750, 3, 20, 14, 0, 0);
        arrayCar[2] = new PerformanceCar("Toyota", "GR Supra (A90/A91)", 2025,
                382, 2, 30, 14, new String[0]);

        Race race = new CasualRace(1000, "Linear track", 1000, arrayCar);

        winner = race.startRace(arrayCar); // Для простоты эксперимента
                                           // сравнение идёт только по мощности
        System.out.println("\n" + winner + "\n");
        System.out.print("Автомобиль 1, 2 или 3 вы хотите улучшить? ");

        Scanner scanner = new Scanner(System.in);
        garage.setParkedCars(arrayCar);
        garage.modifyCar(scanner.nextInt());

        System.out.println("\nПовторный заезд...");
        winner = race.startRace(garage.getParkedCars());
        System.out.println(winner);
    }
}
