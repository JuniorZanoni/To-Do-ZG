package menus;

import tasks.Alarm;
import utils.ClearConsole;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

public class MenuPrincipal {

    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Alarm.clearAlarms();
        Alarm.checkAlarms();
        ClearConsole.clear();
        menu();
    }

    public static void menu() throws FileNotFoundException, ParseException {
        TaskCounterPanel.panel();

        System.out.println("Digite o número da opção desejada.");
        System.out.println("0 - Listar tarefas");
        System.out.println("1 - Criar tarefa");
        System.out.println("2 - Deletar tarefa");
        System.out.println("3 - Editar tarefa");
        System.out.println("4 - Criar categoria");
        System.out.println("5 - Criar alarme");
        System.out.println("6 - Sair");

        Scanner sc1 = new Scanner(System.in);
        String option = sc1.nextLine();

        switch (option) {
            case "0":
                new MenuListTask().listTasks();
                break;
            case "1":
                new MenuCreateTask().createTask();
                break;
            case "2":
                new MenuDeleteTask().deleteTask();
                break;
            case "3":
                new MenuEditTask().menuEdit();
                break;
            case "4":
                new MenuCategory().createCategory();
                break;
            case "5":
                MenuCreateAlarm.menu();
                break;
            case"6": System.exit(0); break;
            default:
                ClearConsole.clear();
                System.out.println("Opção inválida");
                MenuPrincipal.menu();
        }
    }
}
