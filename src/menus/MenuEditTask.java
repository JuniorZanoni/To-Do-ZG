package menus;

import tasks.Task;
import utils.ClearConsole;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class MenuEditTask {
    public void menuEdit() throws FileNotFoundException, ParseException {
        ClearConsole.clear();
        verifyTasks();
        System.out.println("Digite o número da tarefa que deseja editar");

        Task.getListTask().forEach(task -> System.out.println(task.getStringTask()));

        Scanner scOption = new Scanner(System.in);

        if (scOption.hasNextInt()) {
            int id = scOption.nextInt();
            boolean condition = false;

            for (Task task : Task.getListTask()) {
                if (task.getIdTask() == id) {
                    condition = true;
                }
            }

            if (condition) {
                Task taskEdit;

                for (Task task : Task.getListTask()) {
                    if (task.getIdTask() == id) {
                        ClearConsole.clear();

                        taskEdit = task;

                        System.out.println("Escolha o campo que deseja editar");
                        System.out.println("0 - Editar nome");
                        System.out.println("1 - Editar descrição");
                        System.out.println("2 - Editar prioridade");
                        System.out.println("3 - Editar status");
                        System.out.println("4 - Editar categoria");

                        Scanner scOption2 = new Scanner(System.in);

                        if (scOption2.hasNextInt()) {
                            int option = scOption2.nextInt();

                            switch (option) {
                                case 0:
                                    ClearConsole.clear();
                                    this.editarNome(taskEdit, id);
                                    break;
                                case 1:
                                    ClearConsole.clear();
                                    this.editarDescricao(taskEdit, id);
                                    break;
                                case 2:
                                    ClearConsole.clear();
                                    this.editarPrioridade(taskEdit, id);
                                    break;
                                case 3:
                                    ClearConsole.clear();
                                    this.editarStatus(taskEdit, id);
                                    break;
                                case 4:
                                    ClearConsole.clear();
                                    this.editarCategoria(taskEdit, id);
                                    break;
                                default:
                                    menuEdit();
                            }

                            break;
                        } else {
                            menuEdit();
                        }
                    }

                }

                ClearConsole.clear();
                MenuPrincipal.menu();
            } else {
                menuEdit();
            }
        } else {
            menuEdit();
        }
    }

    private void editarNome(Task taskedit, int id) throws FileNotFoundException {
        System.out.println("Digite o novo nome");

        Scanner scName = new Scanner(System.in);
        String name = scName.nextLine();

        taskedit.setName(name);

        Task.edit(id, taskedit);
    }

    private void editarDescricao(Task taskedit, int id) throws FileNotFoundException {
        System.out.println("Digite a nova descrição");

        Scanner scDescriprion = new Scanner(System.in);
        String description = scDescriprion.nextLine();

        taskedit.setDescription(description);

        Task.edit(id, taskedit);
    }

    private void editarPrioridade(Task taskedit, int id) throws FileNotFoundException {
        int prioriry = new MenuPriority().selectPriority();

        taskedit.setPriority(prioriry);

        Task.edit(id, taskedit);
    }

    private void editarStatus(Task taskedit, int id) throws FileNotFoundException {
        String status = new MenuStatus().selectStatus();

        taskedit.setStatus(status);

        Task.edit(id, taskedit);

        if (status.equals("Feito")) {
            Date date = new Date();
            SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
            String dateFormated = dt.format(date);

            taskedit.setCompletionDate(dateFormated);

            Task.edit(id, taskedit);
        }
    }

    private void editarCategoria(Task taskedit, int id) throws FileNotFoundException {
        String category = new MenuCategory().listCategory();

        taskedit.setCategory(category);

        Task.edit(id, taskedit);
    }

    private void verifyTasks() throws FileNotFoundException, ParseException {
        ArrayList<Task> tasks = Task.getListTask();
        if (tasks.size() == 0) {
            ClearConsole.clear();
            System.out.println("Você não tem nenhuma tarefa cadastrada");
            MenuPrincipal.menu();
        }
    }
}
