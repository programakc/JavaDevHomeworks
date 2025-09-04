package homeworks.homework09;

public class CasualRace extends Race {

    public CasualRace() {
    }

    public CasualRace(int distance, String route, int prizeFund, Car[] raceParticipants) {
        super(distance, route, prizeFund, raceParticipants);
    }

    @Override
    public String toString() {
        return "CasualRace{}";
    }
}
