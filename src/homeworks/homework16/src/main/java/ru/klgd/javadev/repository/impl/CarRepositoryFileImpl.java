package ru.klgd.javadev.repository.impl;

import ru.klgd.javadev.exception.CarNotFoundException;
import ru.klgd.javadev.model.car.ShowCar;
import ru.klgd.javadev.repository.CarRepository;
import ru.klgd.javadev.model.car.Car;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CarRepositoryFileImpl implements CarRepository {

    private final List<Car> CARS = new ArrayList<>();
    private final static String FILENAME = "Resources.txt";

    public CarRepositoryFileImpl() {
        readFile();
    }

    @Override
    public void create(Car car) {
        CARS.add(car);
        writeFile();
    }

    @Override
    public Car findById(String id) {
        return CARS
                .stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new CarNotFoundException(
                        "Автомобиль с гос. номером: " + id + " не найден!"));
    }

    @Override
    public List<Car> findAll() {
        return CARS;
    }

    @Override
    public void update(Car car) {

        try {
            Car foundedCar = CARS.stream()
                    .filter(e -> e.getId().equals(car.getId()))
                    .findFirst()
                    .orElseThrow(() -> new CarNotFoundException(
                            "Автомобиль с гос. номером: " + car.getId() + " "
                                    + "не найден!"));

            foundedCar.update(car);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            CARS.add(car);
        }

        writeFile();
    }

    @Override
    public void deleteById(String id) {
        CARS.removeIf(car -> car.getId().equals(id));
        writeFile();
    }

    @Override
    public void deleteAll() {
        CARS.clear();
        writeFile();
    }

    private void readFile() {
        List<Car> result;

        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(FILENAME))) {

            result = bufferedReader.lines()
                    .map(Car::new)
                    .toList();

        } catch (IOException e) {
            System.out.println("Не удалось найти файл " + FILENAME);
            result = new ArrayList<>();
        }

        CARS.addAll(result);
    }

    private void writeFile() {
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter(FILENAME))) {

            for (Car c : CARS) {
                bufferedWriter.write(c.toString() + "\n");
            }

        } catch (IOException e) {
            System.out.println("Не удалось найти файл " + FILENAME);
        }
    }
}
