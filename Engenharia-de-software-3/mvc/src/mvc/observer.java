package mvc;

import java.util.ArrayList;
import java.util.List;

interface TaskObserver {
    void onTaskUpdated();
}

class TaskManager {
    private final List<TaskObserver> observers = new ArrayList<>();

    public void addObserver(TaskObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (TaskObserver observer : observers) {
            observer.onTaskUpdated();
        }
    }
}
