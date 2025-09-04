package homeworks.homework09;

import java.util.Objects;

public class ShowCar extends Car {

    private int stars = 0;
    private int popularity;

    public ShowCar() {
    }

    public ShowCar(int stars, int popularity) {
        this.stars = stars;
        this.popularity = popularity;
    }

    public ShowCar(String brand, String model, int yearOfRelease, int power,
                   int acceleration, int suspension, int durability, int stars,
                   int popularity) {

        super(brand, model, yearOfRelease, power, acceleration, suspension, durability);
        this.stars = stars;
        this.popularity = popularity;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ShowCar showCar = (ShowCar) o;
        return stars == showCar.stars && popularity == showCar.popularity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), stars, popularity);
    }

    @Override
    public String toString() {
        return "ShowCar{" +
                "brand='" + super.getBrand() + '\'' +
                ", model='" + super.getModel() + '\'' +
                ", yearOfRelease=" + super.getYearOfRelease() +
                ", power=" + super.getPower() +
                ", acceleration=" + super.getAcceleration() +
                ", suspension=" + super.getSuspension() +
                ", durability=" + super.getDurability() +
                ", stars=" + stars +
                ", popularity=" + popularity +
                '}';
    }
}
