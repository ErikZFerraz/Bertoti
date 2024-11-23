package mvc;

import java.util.ArrayList;
import java.util.List;

public class MVC {
    public static void main(String[] args) {
        // Configuração inicial de tarefas
        Task mainTask = new Task("Projeto Final");
        Task subTask1 = new Task("Escrever código");
        Task subTask2 = new Task("Revisar documentação");

        mainTask.addSubtask(subTask1);
        mainTask.addSubtask(subTask2);

        List<TaskComponent> tasks = new ArrayList<>();
        tasks.add(mainTask);

        // Configuração da visão e do controlador
        TaskManager taskManager = new TaskManager();
        TaskView view = new TaskView(tasks);
        TaskController controller = new TaskController(tasks, view, taskManager);

        // Exibir todas as tarefas inicialmente
        System.out.println("Exibindo todas as tarefas:");
        view.displayTasks();

        // Marcar uma tarefa como concluída e mudar para exibir apenas tarefas concluídas
        controller.completeTask(subTask1);
        System.out.println("\nExibindo apenas tarefas concluídas:");
        controller.setViewDisplayStrategy(new CompletedTasksDisplayStrategy());
    }
}
