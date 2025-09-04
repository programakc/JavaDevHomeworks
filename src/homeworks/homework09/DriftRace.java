package homeworks.homework09;

public class DriftRace extends Race {

    public DriftRace() {
    }

    public DriftRace(int distance, String route, int prizeFund, Car[] raceParticipants) {
        super(distance, route, prizeFund, raceParticipants);
    }

    @Override
    public String toString() {
        return "DriftRace{}";
    }
}
