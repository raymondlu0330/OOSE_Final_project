import java.util.ArrayList;
import java.util.List;

class FlightMission {
    private List<Observer> obs = new ArrayList<>();

    public void addObserver(Observer ob) {
        obs.add(ob);
    }

    public void notifyObservers(String status) {
        for (Observer ob : obs) {
            ob.update(status);
        }
    }

    public void startMission(){
        System.out.println("Mission started.");
        notifyObservers("Flight mission in progress...");
    }
    public void completeMission(){
        System.out.println("Mission completed.");
        notifyObservers("Flight mission all completed.");
    }
}

interface  Observer{
    void update(String status);
}

class MissionControl implements Observer{
    @Override
    public void update(String status) {
        System.out.println("Mission Control: " + status);
    }
}
