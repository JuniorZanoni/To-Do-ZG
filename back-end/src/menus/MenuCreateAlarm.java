package menus;

import tasks.Alarm;
import tasks.Task;
import utils.ClearConsole;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MenuCreateAlarm {

    public static void menu() throws FileNotFoundException, ParseException {
        if(Task.getListTask().isEmpty()) {
            ClearConsole.clear();
            System.out.println("Você não tem nenhuma tarefa cadastrada para criar alarme");
            MenuPrincipal.menu();
        } else {
            ClearConsole.clear();

            int idTask = chooseTask();
            LocalDate alarmDate = Alarm.convertStringInLocalDate(chooseDate());
            LocalTime alarmTime = Alarm.convertStringInLocalTime(chooseTime());
            int minutesBefore = chooseMinutesBefore();

            Alarm alarm = new Alarm(idTask, alarmDate, alarmTime, minutesBefore);
            Alarm.saveAlarm(alarm);

            ClearConsole.clear();
            MenuPrincipal.menu();
        }
    }

    private static int chooseTask() {
        ArrayList<Task> listTasks = Task.getListTask();

        ClearConsole.clear();
        System.out.println("Digite o número da tarefa que deseja criar o alarme");

        listTasks.forEach(task -> System.out.println(task.getStringTask()));
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int idTask = sc.nextInt();
            boolean condition = false;

            for (Task task : listTasks) {
                if (task.getIdTask() == idTask) {
                    condition = true;
                    break;
                }
            }

            if (condition) {
                return idTask;
            } else {
                return chooseTask();
            }
        } else {
            return chooseTask();
        }
    }

    private static String chooseDate() {
        String regex = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$";

        ClearConsole.clear();
        System.out.println("Digite a data que deseja ser avisado, no formato dd/mm/aaaa");

        Scanner sc = new Scanner(System.in);
        String date = sc.nextLine();

        if (Pattern.compile(regex).matcher(date).find()) {
            return date;
        } else {
            return chooseDate();
        }
    }

    private static String chooseTime() {
        String regex = "^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$";

        ClearConsole.clear();
        System.out.println("Digite a hora que deseja ser avisado, no formato hh:mm");

        Scanner sc = new Scanner(System.in);
        String time = sc.nextLine();

        if (Pattern.compile(regex).matcher(time).find()) {
            return time;
        } else {
            return chooseTime();
        }
    }

    private static int chooseMinutesBefore() {
        ClearConsole.clear();
        System.out.println("Digite com quantos minutos de antecedência quer ser avisado");

        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            return sc.nextInt();
        } else {
            return chooseMinutesBefore();
        }
    }

}
