package mvc;

import java.util.List;

interface DisplayStrategy {
    void display(List<TaskComponent> tasks);
}

class AllTasksDisplayStrategy implements DisplayStrategy {
    @Override
    public void display(List<TaskComponent> tasks) {
        System.out.println("All Tasks:");
        for (TaskComponent task : tasks) {
            task.display();
        }
    }
}

class CompletedTasksDisplayStrategy implements DisplayStrategy {
    @Override
    public void display(List<TaskComponent> tasks) {
        System.out.println("Completed Tasks:");
        for (TaskComponent task : tasks) {
            if (task instanceof Task && ((Task) task).isCompleted()) {
                task.display();
            }
        }
    }
}
