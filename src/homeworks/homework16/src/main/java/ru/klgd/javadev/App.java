package ru.klgd.javadev;

import ru.klgd.javadev.model.car.Car;
import ru.klgd.javadev.model.car.PerformanceCar;
import ru.klgd.javadev.model.car.ShowCar;
import ru.klgd.javadev.model.garage.Garage;
import ru.klgd.javadev.model.race.CasualRace;
import ru.klgd.javadev.model.race.Race;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        String winner;
        Garage garage = new Garage();
        Car[] arrayCar = new Car[3];

        /*arrayCar[0] = new PerformanceCar("Performance car", "е666кх", "Nissan",
                "Z (RZ34)", 2025,
                400, 4, 30, 14, new String[0]);
        arrayCar[1] = new ShowCar("Show car", "е111кх", "McLaren",
                "750S", 2025, 750, 3,
                20, 14, 0, 0);
        arrayCar[2] = new PerformanceCar("Performance car", "м001эр", "Toyota", "GR Supra " +
                "(A90/A91)", 2025, 382, 2, 30, 14, new String[0]);*/

        Race race = CasualRace.builder()
                .distance(1000)
                .route("Linear track")
                .prizeFund(1000)
                .raceParticipants(arrayCar)
                .build();

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
