package tasks;

import data.Data;

import java.io.FileNotFoundException;
import java.util.ArrayList;


public class Task implements Comparable<Task> {
    private static ArrayList<Task> listTask;

    private static int id;

    static {
        listTask = Data.loadTasks();
        id = listTask.size();
    }

    private String name;
    private String description;
    private int priority;
    private String status;
    private String category;
    private int idTask;
    private String completionDate;
    private String creationDate;

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Task(Integer id, String name, String description, int priority, String status, String category) {
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.category = category;
        this.idTask = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public String getStatus() {
        return status;
    }

    public String getCategory() {
        return category;
    }

    public static void save(Task task) throws FileNotFoundException {
        listTask.add(task);
        Data.saveTasks();
        id++;
    }

    public static void delete(int id) throws FileNotFoundException {
        listTask.removeIf(task -> task.getIdTask() == id);
        Data.saveTasks();
    }

    public static void edit(int id, Task task) throws FileNotFoundException {
        int count = 0;

        for (Task task2 : listTask) {
            if (task2.getIdTask() == id) {
                listTask.set(count, task);
            }
            count++;
        }

        Data.saveTasks();
    }

    public String getStringTask() {
        if (this.getStatus().equals("Feito")) {
            return
                    this.getIdTask() + " | "
                            + "Tarefa: " + this.getName() + " | "
                            + this.getDescription() + " | "
                            + "Prioridade: " + this.getPriority() + " | "
                            + "Status: " + this.getStatus() + " | "
                            + "Categoria: " + this.getCategory() + " | "
                            + "Concluida em: " + this.getCompletionDate();
        } else {
            return
                    this.getIdTask() + " | "
                            + "Tarefa: " + this.getName() + " | "
                            + this.getDescription() + " | "
                            + "Prioridade: " + this.getPriority() + " | "
                            + "Status: " + this.getStatus() + " | "
                            + "Categoria: " + this.getCategory();
        }
    }

    public static int getId() {
        return id;
    }

    public int getIdTask() {
        return idTask;
    }

    public static ArrayList<Task> getListTask() {
        return listTask;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }

    @Override
    public int compareTo(Task o) {
        if (this.priority > o.priority) {
            return -1;
        }
        if (this.priority < o.priority) {
            return 1;
        }
        return 0;
    }
}
