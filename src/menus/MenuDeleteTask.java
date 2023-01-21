package menus;

import tasks.Task;
import utils.ClearConsole;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuDeleteTask {

    public void deleteTask() throws FileNotFoundException, ParseException {
        ClearConsole.clear();
        if (verifyTasks() == true) {
            System.out.println("Digite o número da tarefa que deseja apagar");
            Task.getListTask().forEach(task -> System.out.println(task.getStringTask()));

            Scanner scTask = new Scanner(System.in);

            if (scTask.hasNextInt()) {
                int indexTask = scTask.nextInt();
                Boolean condition = false;

                for (Task task : Task.getListTask()) {
                    if (task.getIdTask() == indexTask) {
                        condition = true;
                    }
                }

                if (condition) {
                    Task.delete(indexTask);
                    ClearConsole.clear();
                    System.out.println("Tarefa apagada com sucesso!");
                    MenuPrincipal.menu();
                } else {
                    deleteTask();
                }
            } else {
                deleteTask();
            }
        } else {
            deleteTask();
        }


    }

    private boolean verifyTasks() throws FileNotFoundException, ParseException {
        ArrayList<Task> tasks = Task.getListTask();
        if (tasks.size() == 0) {
            ClearConsole.clear();
            System.out.println("Você não tem nenhuma tarefa cadastrada");
            return false;
        } else {
            return true;
        }
    }

}
