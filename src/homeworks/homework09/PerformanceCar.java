package homeworks.homework09;

import java.util.Arrays;
import java.util.Objects;

public class PerformanceCar extends Car {

    private String[] addons = {};

    public PerformanceCar() {
    }

    public PerformanceCar(String[] addons) {
        this.addons = addons;
    }

    public PerformanceCar(String brand, String model, int yearOfRelease, int power,
                          int acceleration, int suspension, int durability, String[] addons) {

        super(brand, model, yearOfRelease, (int) (power * 1.5), acceleration,
                (int) (suspension * 0.75), durability);

        this.addons = addons;
    }

    public String[] getAddons() {
        return addons;
    }

    public void setAddons(String[] addons) {
        this.addons = addons;
    }

    @Override
    public void setPower(int power) {
        super.setPower((int) (power * 1.5));
    }

    @Override
    public void setSuspension(int suspension) {
        super.setSuspension((int) (suspension * 0.75));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PerformanceCar that = (PerformanceCar) o;
        return Objects.deepEquals(addons, that.addons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Arrays.hashCode(addons));
    }

    @Override
    public String toString() {
        return "PerformanceCar{" +
                "brand='" + super.getBrand() + '\'' +
                ", model='" + super.getModel() + '\'' +
                ", yearOfRelease=" + super.getYearOfRelease() +
                ", power=" + super.getPower() +
                ", acceleration=" + super.getAcceleration() +
                ", suspension=" + super.getSuspension() +
                ", durability=" + super.getDurability() +
                ", addons=" + Arrays.toString(addons) +
                '}';
    }
}
