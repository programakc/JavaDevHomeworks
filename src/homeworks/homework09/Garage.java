package homeworks.homework09;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Garage {

    private Car[] parkedCars;

    public Garage() {
    }

    public Garage(Car[] parkedCars) {
        this.parkedCars = parkedCars;
    }

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

    public Car[] getParkedCars() {
        return parkedCars;
    }

    public void setParkedCars(Car[] parkedCars) {
        this.parkedCars = parkedCars;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Garage garage = (Garage) o;
        return Objects.deepEquals(parkedCars, garage.parkedCars);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(parkedCars);
    }

    @Override
    public String toString() {
        return "Garage{" +
                "parkedCars=" + Arrays.toString(parkedCars) +
                '}';
    }
}
