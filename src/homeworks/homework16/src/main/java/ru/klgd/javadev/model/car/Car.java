package ru.klgd.javadev.model.car;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Car {

    private String type;
    private String id;
    private String brand;
    private String model;
    private int yearOfRelease;
    private int power;
    private int acceleration;
    private int suspension;
    private int durability;

    public Car(String inputLine) {
        String[] params = inputLine.split("\\|");

        this.type = params[0];
        this.id = params[1];
        this.brand = params[2];
        this.model = params[3];
        this.yearOfRelease = Integer.parseInt(params[4]);
        this.power = Integer.parseInt(params[5]);
        this.acceleration = Integer.parseInt(params[6]);
        this.suspension = Integer.parseInt(params[7]);
        this.durability = Integer.parseInt(params[8]);
    }

    @Override
    public String toString() {
        return (type + "|" + id + "|" + brand + "|" + model + "|"
                + yearOfRelease + "|" + power + "|" + acceleration + "|"
                + suspension + "|" + durability);
    }
}
