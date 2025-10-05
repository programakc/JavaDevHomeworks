package ru.klgd.javadev.model.garage;

import lombok.*;
import ru.klgd.javadev.model.car.Car;
import ru.klgd.javadev.model.car.PerformanceCar;
import ru.klgd.javadev.model.car.ShowCar;

import java.util.Scanner;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Garage {

    private Car[] parkedCars;

    public void modifyCar(int numberCar) {
        Car car;
        numberCar--;

        if (parkedCars[numberCar] instanceof PerformanceCar) {
            car = (PerformanceCar) parkedCars[numberCar];
        } else if (parkedCars[numberCar] instanceof ShowCar) {
            car = (ShowCar) parkedCars[numberCar];
        } else {
            car = parkedCars[numberCar];
        }

        System.out.print("Какая мощность будет теперь у " + car.getBrand()
        + "? ");

        Scanner scanner = new Scanner(System.in);
        car.setPower(scanner.nextInt());
    }

}
