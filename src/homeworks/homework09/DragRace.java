package homeworks.homework09;

public class DragRace extends Race {

    public DragRace() {
    }

    public DragRace(int distance, String route, int prizeFund, Car[] raceParticipants) {
        super(distance, route, prizeFund, raceParticipants);
    }

    @Override
    public String toString() {
        return "DragRace{}";
    }
}
