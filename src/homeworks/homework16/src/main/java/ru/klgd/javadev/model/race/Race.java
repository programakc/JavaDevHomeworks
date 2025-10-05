package ru.klgd.javadev.model.race;

import lombok.*;
import ru.klgd.javadev.model.car.Car;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class Race {

    private int distance;
    private String route;
    private int prizeFund;
    private Car[] raceParticipants;

    public String startRace (Car[] raceCar) {
        int winNum = 0;
        int maxPower = 0;
        for (int i = 0; i < raceCar.length; i++) {
            if (maxPower < raceCar[i].getPower()) {
                maxPower = raceCar[i].getPower();
                winNum = i;
            }
        }
        return "Победил гонщик на " + raceCar[winNum].getBrand();
    }

}
