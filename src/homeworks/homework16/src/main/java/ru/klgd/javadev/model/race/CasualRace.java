package ru.klgd.javadev.model.race;

import lombok.NoArgsConstructor;
import lombok.ToString;
import ru.klgd.javadev.model.car.Car;

@NoArgsConstructor
@ToString
public class CasualRace extends Race {

    public CasualRace(int distance, String route, int prizeFund, Car[] raceParticipants) {
        super(distance, route, prizeFund, raceParticipants);
    }
}
