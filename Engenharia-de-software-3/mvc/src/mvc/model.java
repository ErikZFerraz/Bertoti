package mvc;

import java.util.ArrayList;
import java.util.List;

interface TaskComponent {
    void display();  // Método para exibir a tarefa
}

class Task implements TaskComponent {
    private final String name;
    private boolean completed;
    private final List<TaskComponent> subtasks = new ArrayList<>();

    public Task(String name) {
        this.name = name;
    }

    public void addSubtask(TaskComponent subtask) {
        subtasks.add(subtask);
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public void display() {
        System.out.println("Task: " + name + (completed ? " [Completed]" : " [Pending]"));
        for (TaskComponent subtask : subtasks) {
            subtask.display();
        }
    }
}
