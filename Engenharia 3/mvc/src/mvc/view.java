package mvc;

import java.util.List;

class TaskView implements TaskObserver {
    private DisplayStrategy displayStrategy;
    private final List<TaskComponent> tasks;

    public TaskView(List<TaskComponent> tasks) {
        this.tasks = tasks;
        this.displayStrategy = new AllTasksDisplayStrategy();  // Estratégia padrão
    }

    public void setDisplayStrategy(DisplayStrategy displayStrategy) {
        this.displayStrategy = displayStrategy;
    }

    public void displayTasks() {
        displayStrategy.display(tasks);
    }

    @Override
    public void onTaskUpdated() {
        System.out.println("Atualização de tarefas recebida.");
        displayTasks();
    }
}
