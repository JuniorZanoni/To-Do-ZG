package data;

import tasks.Alarm;
import tasks.Category;
import tasks.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Data {

    public static ArrayList<Task> loadTasks() {

        ArrayList<Task> tasks = new ArrayList<>();

        Scanner scanner = null;

        try {
            scanner = new Scanner(new File("tasks.csv"));
        } catch (FileNotFoundException e) {
            return tasks;
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] valores = line.split(",");

            String name = valores[0];
            String description = valores[1];
            int priority = Integer.parseInt(valores[2]);
            String status = valores[3];
            String category = valores[4];
            int idTask = Integer.parseInt(valores[5]);

            Task task = new Task(idTask, name, description, priority, status, category);
            task.setCreationDate(valores[6]);
            task.setCompletionDate(valores[7]);

            tasks.add(task);
        }

        scanner.close();

        return tasks;
    }

    public static void saveTasks() throws FileNotFoundException {
        PrintStream ps = new PrintStream("tasks.csv");

        ArrayList<Task> listTasks = Task.getListTask();

        Collections.sort(listTasks);

        listTasks.forEach(task -> {
            ps.print(task.getName());
            ps.print(",");
            ps.print(task.getDescription());
            ps.print(",");
            ps.print(task.getPriority());
            ps.print(",");
            ps.print(task.getStatus());
            ps.print(",");
            ps.print(task.getCategory());
            ps.print(",");
            ps.print(task.getIdTask());
            ps.print(",");
            ps.print(task.getCreationDate());
            ps.print(",");
            ps.print(task.getCompletionDate());
            ps.println();
        });

        ps.close();

    }

    public static ArrayList<String> loadCategorys() throws FileNotFoundException {

        ArrayList<String> categorys = new ArrayList<>();

        Scanner scanner = new Scanner(new File("categorys.csv"));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] valores = line.split(",");

            String category = valores[0];

            categorys.add(category);

        }

        scanner.close();

        return categorys;
    }

    public static void saveCategorys() throws FileNotFoundException {
        PrintStream ps = new PrintStream("categorys.csv");

        ArrayList<String> listCategory = Category.getListCategory();

        listCategory.forEach(category -> {
            ps.print(category);
            ps.print(",");
            ps.println();
        });

        ps.close();
    }

    public static ArrayList<Alarm> loadAlarms() {

        ArrayList<Alarm> listAlarms = new ArrayList<>();

        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("alarms.csv"));
        } catch (FileNotFoundException e) {
            return listAlarms;
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] valores = line.split(",");

            String[] localDate = valores[1].split("-");
            int year = Integer.parseInt(localDate[0]);
            int month = Integer.parseInt(localDate[1]);
            int day = Integer.parseInt(localDate[2]);

            String[] localTime = valores[2].split(":");
            int hour = Integer.parseInt(localTime[0]);
            int minute = Integer.parseInt(localTime[1]);

            int idTask = Integer.parseInt(valores[0]);
            LocalDate alarmDate = LocalDate.of(year, month, day);
            LocalTime alarmTime = LocalTime.of(hour, minute);
            int minutesBefore = Integer.parseInt(valores[3]);

            Alarm alarm = new Alarm(idTask, alarmDate, alarmTime, minutesBefore);

            listAlarms.add(alarm);
        }

        scanner.close();

        return listAlarms;
    }

    public static void saveAlarms() throws FileNotFoundException {
        PrintStream ps = new PrintStream("alarms.csv");

        ArrayList<Alarm> listAlarms = Alarm.listAlarms;

        listAlarms.forEach(alarm -> {
            ps.print(alarm.getIdTask());
            ps.print(",");
            ps.print(alarm.getAlarmDate().toString());
            ps.print(",");
            ps.print(alarm.getAlarmTime().toString());
            ps.print(",");
            ps.print(alarm.getMinutesBefore());
            ps.println();
        });

        ps.close();

    }
}
