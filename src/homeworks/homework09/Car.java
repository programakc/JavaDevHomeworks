package homeworks.homework09;

import java.util.Objects;

public class Car {

    private String brand;
    private String model;
    private int yearOfRelease;
    private int power;
    private int acceleration;
    private int suspension;
    private int durability;

    public Car() {
    }

    public Car(String brand, String model, int yearOfRelease, int power,
               int acceleration, int suspension, int durability) {

        this.brand = brand;
        this.model = model;
        this.yearOfRelease = yearOfRelease;
        this.power = power;
        this.acceleration = acceleration;
        this.suspension = suspension;
        this.durability = durability;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public int getPower() {
        return power;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public int getSuspension() {
        return suspension;
    }

    public int getDurability() {
        return durability;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    public void setSuspension(int suspension) {
        this.suspension = suspension;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return yearOfRelease == car.yearOfRelease && power == car.power &&
                acceleration == car.acceleration && suspension == car.suspension &&
                durability == car.durability && Objects.equals(brand, car.brand) &&
                Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, yearOfRelease, power, acceleration,
                suspension, durability);
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", power=" + power +
                ", acceleration=" + acceleration +
                ", suspension=" + suspension +
                ", durability=" + durability +
                '}';
    }
}
