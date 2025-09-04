package homeworks.homework09;

import java.util.Arrays;
import java.util.Objects;

public class Race {

    private int distance;
    private String route;
    private int prizeFund;
    private Car[] raceParticipants;

    public Race() {
    }

    public Race(int distance, String route, int prizeFund, Car[] raceParticipants) {
        this.distance = distance;
        this.route = route;
        this.prizeFund = prizeFund;
        this.raceParticipants = raceParticipants;
    }

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

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public int getPrizeFund() {
        return prizeFund;
    }

    public void setPrizeFund(int prizeFund) {
        this.prizeFund = prizeFund;
    }

    public Car[] getRaceParticipants() {
        return raceParticipants;
    }

    public void setRaceParticipants(Car[] raceParticipants) {
        this.raceParticipants = raceParticipants;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Race race = (Race) o;
        return distance == race.distance && prizeFund == race.prizeFund &&
                Objects.equals(route, race.route) && Objects.deepEquals(raceParticipants,
                race.raceParticipants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance, route, prizeFund, Arrays.hashCode(raceParticipants));
    }

    @Override
    public String toString() {
        return "Race{" +
                "distance=" + distance +
                ", route='" + route + '\'' +
                ", prizeFund=" + prizeFund +
                ", raceParticipants=" + Arrays.toString(raceParticipants) +
                '}';
    }
}
