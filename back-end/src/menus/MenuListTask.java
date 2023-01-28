package menus;

import data.Data;
import tasks.Task;
import utils.ClearConsole;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MenuListTask {
    ArrayList<Task> tasks = Task.getListTask();

    public void listTasks() throws FileNotFoundException, ParseException {

        verifyTasks();

        Data.loadTasks();

        ClearConsole.clear();
        System.out.println("Digite o número do filtro");
        System.out.println("0 - Listar todas tarefas");
        System.out.println("1 - Listar por categoria");
        System.out.println("2 - Listar por prioridade");
        System.out.println("3 - Listar por status");
        System.out.println("4 - Listar por data");

        Scanner scFilter = new Scanner(System.in);

        if (scFilter.hasNextInt()) {
            int filter = scFilter.nextInt();

            if (filter <= 4 && filter >= 0) {
                switch (filter) {
                    case 0:
                        ClearConsole.clear();
                        this.allTasks();
                        break;
                    case 1:
                        ClearConsole.clear();
                        this.filterCategory();
                        break;
                    case 2:
                        ClearConsole.clear();
                        this.filterPriority();
                        break;
                    case 3:
                        ClearConsole.clear();
                        this.filterStatus();
                        break;
                    case 4:
                        ClearConsole.clear();
                        this.filterDate();
                        break;
                }
            } else {
                new MenuListTask().listTasks();
            }
        } else {
            new MenuListTask().listTasks();
        }
    }

    private void filterDate() throws FileNotFoundException, ParseException {
        ClearConsole.clear();
        System.out.println("Escolha por qual tipo de data quer filtrar.");
        System.out.println("0 - Data de criação");
        System.out.println("1 - Data de conclusão");

        Scanner scOption = new Scanner(System.in);

        if (scOption.hasNextInt()) {
            int option = scOption.nextInt();

            if (option == 0) {
                ClearConsole.clear();
                System.out.println("Escolha uma data, você tem tarefas criadas em");

                Set<String> setDates = new HashSet<>();
                Task.getListTask().forEach(task -> setDates.add(task.getCreationDate()));

                AtomicInteger count = new AtomicInteger();
                List listDates = new ArrayList<>(setDates);
                listDates.forEach(date -> {
                    System.out.println(count + " - " + date);
                    count.getAndIncrement();
                });

                Scanner scStatus = new Scanner(System.in);

                if (scStatus.hasNextInt()) {
                    int index = scStatus.nextInt();

                    if (index <= listDates.size() - 1 && index >= 0) {
                        ClearConsole.clear();
                        Task.getListTask().forEach(task -> {
                            if (task.getCreationDate().equals(listDates.get(index))) {
                                ClearConsole.clear();
                                System.out.println(task.getStringTask());
                                try {
                                    MenuPrincipal.menu();
                                } catch (FileNotFoundException e) {
                                    throw new RuntimeException(e);
                                } catch (ParseException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            ;
                        });
                    } else {
                        filterDate();
                    }

                } else {
                    filterDate();
                }
            }

            if (option == 1) {
                ClearConsole.clear();
                Set<String> setDates = new HashSet<>();

                Task.getListTask().forEach(task -> {
                    if (!task.getCompletionDate().equals("null")) {
                        setDates.add(task.getCompletionDate());
                    }
                });

                if (setDates.size() == 0) {
                    ClearConsole.clear();
                    System.out.println("Você não tem nenhuma tarefa concluida ainda");
                    MenuPrincipal.menu();
                } else {
                    System.out.println("Escolha uma data, você tem tarefas concluidas em");

                    AtomicInteger count = new AtomicInteger();
                    List listDates = new ArrayList<>(setDates);
                    listDates.forEach(date -> {
                        System.out.println(count + " - " + date);
                        count.getAndIncrement();
                    });

                    Scanner scStatus = new Scanner(System.in);

                    if (scStatus.hasNextInt()) {
                        int index = scStatus.nextInt();

                        if (index <= listDates.size() - 1 && index >= 0) {
                            ClearConsole.clear();
                            Task.getListTask().forEach(task -> {
                                if (task.getCompletionDate().equals(listDates.get(index))) {
                                    System.out.println(task.getStringTask());
                                }
                                ;
                            });

                            MenuPrincipal.menu();
                        } else {
                            filterDate();
                        }
                    } else {
                        filterDate();
                    }
                }
            }

            if (option != 0 || option != 1) {
                filterDate();
            }
        } else {
            filterDate();
        }
    }

    private void filterCategory() throws FileNotFoundException, ParseException {

        String category = new MenuCategory().listCategory();

        ClearConsole.clear();
        for (Task task : tasks) {
            if (task.getCategory().equals(category)) {
                System.out.println(task.getStringTask());
            }
        }
        MenuPrincipal.menu();
    }

    private void filterPriority() throws FileNotFoundException, ParseException {

        int priority = new MenuPriority().selectPriority();

        ClearConsole.clear();
        for (Task task : tasks) {
            if (task.getPriority() == priority) {
                System.out.println(task.getStringTask());
            }
        }
        MenuPrincipal.menu();
    }

    private void filterStatus() throws FileNotFoundException, ParseException {

        String status = new MenuStatus().selectStatus();

        ClearConsole.clear();
        for (Task task : tasks) {
            if (task.getStatus().equals(status)) {
                System.out.println(task.getStringTask());
            }
        }
        MenuPrincipal.menu();
    }

    private void allTasks() throws FileNotFoundException, ParseException {
        Task.getListTask().forEach(task -> System.out.println(task.getStringTask()));
        MenuPrincipal.menu();
    }

    private void verifyTasks() throws FileNotFoundException, ParseException {
        if (tasks.size() == 0) {
            ClearConsole.clear();
            System.out.println("Você não tem nenhuma tarefa cadastrada");
            MenuPrincipal.menu();
        }
    }

}
