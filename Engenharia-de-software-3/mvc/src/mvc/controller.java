package mvc;

import java.util.List;

class TaskController {
    private final List<TaskComponent> tasks;
    private final TaskView view;
    private final TaskManager taskManager;

    public TaskController(List<TaskComponent> tasks, TaskView view, TaskManager taskManager) {
        this.tasks = tasks;
        this.view = view;
        this.taskManager = taskManager;
        taskManager.addObserver(view);
    }

    public void addTask(TaskComponent task) {
        tasks.add(task);
        taskManager.notifyObservers();
    }

    public void completeTask(Task task) {
        task.setCompleted(true);
        taskManager.notifyObservers();
    }

    public void setViewDisplayStrategy(DisplayStrategy strategy) {
        view.setDisplayStrategy(strategy);
        taskManager.notifyObservers();
    }
}
