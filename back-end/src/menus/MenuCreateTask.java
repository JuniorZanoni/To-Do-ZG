package menus;

import tasks.Category;
import tasks.Task;
import utils.ClearConsole;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MenuCreateTask {

    private String name;
    private String description;
    private int priority;
    private String status;
    private String category;

    public void createTask() throws FileNotFoundException, ParseException {
        ClearConsole.clear();
        ArrayList<String> listCategory = Category.getListCategory();

        if (listCategory.size() == 0) {
            System.out.println("Você não tem nenhuma categoria cadastrada, cadastre uma primeiro");
            MenuPrincipal.menu();
        }

        this.createName();
        this.createDescription();
        this.createPriority();
        this.createStatus();
        this.createCategory();

        Task task = new Task(Task.getId(), name, description, priority, status, category);

        Date date = new Date();
        SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
        String dateFormated = dt.format(date);

        task.setCreationDate(dateFormated);

        if (status.equals("Feito")) {
            task.setCompletionDate(dateFormated);
        }

        Task.save(task);

        ClearConsole.clear();
        System.out.println("Tarefa salva!");

        ClearConsole.clear();
        MenuPrincipal.menu();
    }

    private void createName() {
        ClearConsole.clear();
        System.out.println("Qual nome da tarefa?");
        Scanner scName = new Scanner(System.in);

        this.name = scName.nextLine();
    }

    private void createDescription() {
        ClearConsole.clear();
        System.out.println("Qual a descrição");
        Scanner scDescription = new Scanner(System.in);
        this.description = scDescription.nextLine();
    }

    private void createPriority() {
        this.priority = new MenuPriority().selectPriority();
    }

    private void createStatus() {
        this.status = new MenuStatus().selectStatus();
    }

    private void createCategory() {
        this.category = MenuCategory.listCategory();
    }

}
