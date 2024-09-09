import java.util.ArrayList;
import java.util.List;

public class Subject {
    private final List<Observer> observers = new ArrayList<>();
    private boolean state;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void setState(boolean newState) {
        this.state = newState;
        notifyObservers();
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public boolean getState() {
        return state;
    }
}
