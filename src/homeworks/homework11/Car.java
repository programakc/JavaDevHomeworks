package homeworks.homework11;

import java.util.Objects;

public class Car {
    private String number;
    private String model;
    private String color;
    private Integer mileage;
    private Integer cost;

    public Car() {
    }

    public Car(String number, String model, String color, Integer mileage,
               Integer cost) {
        this.number = number;
        this.model = model;
        this.color = color;
        this.mileage = mileage;
        this.cost = cost;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return number == car.number && Objects.equals(model, car.model) &&
                Objects.equals(color, car.color) && Objects.equals(mileage,
                car.mileage) && Objects.equals(cost, car.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, model, color, mileage, cost);
    }

    @Override
    public String toString() {
        return number + " " + model + " " + color + " " + mileage + " " + cost;
    }
}
