package ru.klgd.javadev.model.car;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PerformanceCar extends Car {

    public PerformanceCar(String type, String id, String brand, String model,
                          int yearOfRelease, int power, int acceleration,
                          int suspension, int durability) {

        super(type, id, brand, model, yearOfRelease, (int) (power * 1.5),
                acceleration, (int) (suspension * 0.75), durability);
    }

    @Override
    public void setPower(int power) {
        super.setPower((int) (power * 1.5));
    }

    @Override
    public void setSuspension(int suspension) {
        super.setSuspension((int) (suspension * 0.75));
    }

}
