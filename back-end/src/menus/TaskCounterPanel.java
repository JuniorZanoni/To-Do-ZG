package menus;

import tasks.Task;

import java.util.ArrayList;

public class TaskCounterPanel {

    public static void panel() {
        ArrayList<Task> tasks = Task.getListTask();

        ArrayList tasksToDo = new ArrayList<>();
        ArrayList tasksDoing = new ArrayList<>();
        ArrayList tasksDone = new ArrayList<>();

        for (Task task : tasks) {
            String status = task.getStatus();

            switch (status) {
                case "A fazer":
                    tasksToDo.add(task);
                    break;
                case "Fazendo":
                    tasksDoing.add(task);
                    break;
                default:
                    tasksDone.add(task);
            }
        }

        System.out.println("-------------------Tarefas-------------------");
        System.out.println(
                "|   A fazer - " + tasksToDo.size() + "   " +
                        "Fazendo - " + tasksDoing.size() + "   " +
                        "Feito - " + tasksDone.size() + "   |");
        System.out.println("---------------------------------------------");
    }

}
