package ru.klgd.javadev.model.car;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class ShowCar extends Car {

    int stars = 0;
    private int popularity;

    public ShowCar(String type, String id, String brand, String model,
                   int yearOfRelease, int power, int acceleration, int suspension,
                   int durability, int stars, int popularity) {

        super(type, id, brand, model, yearOfRelease, power, acceleration,
                suspension,
                durability);
        this.stars = stars;
        this.popularity = popularity;
    }

    @Override
    public String toString() {
        return (super.getType() + "|" + super.getId() + "|" + super.getBrand()
                + "|" + super.getModel() + "|" + super.getYearOfRelease() + "|"
                + super.getPower() + "|" + super.getAcceleration() + "|"
                + super.getSuspension() + "|" + super.getDurability() + "|"
                + stars + "|" + popularity);
    }

}
