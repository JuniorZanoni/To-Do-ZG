package tasks;

import data.Data;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;


public class Alarm {
    public static ArrayList<Alarm> listAlarms;

    static {
        listAlarms = Data.loadAlarms();
    }

    private int idTask;
    private LocalDate alarmDate;
    private LocalTime alarmTime;
    private int minutesBefore;

    public Alarm(int idTask, LocalDate alarmDate, LocalTime alarmTime, int minutesBefore) {
        this.idTask = idTask;
        this.alarmDate = alarmDate;
        this.alarmTime = alarmTime;
        this.minutesBefore = minutesBefore;
    }

    public static LocalDate convertStringInLocalDate(String date) {
        String[] dateSplit = date.split("/");

        int year = Integer.parseInt(dateSplit[2]);
        int month = Integer.parseInt(dateSplit[1]);
        int day = Integer.parseInt(dateSplit[0]);

        return LocalDate.of(year, month, day);
    }

    public static LocalTime convertStringInLocalTime(String time) {
        String[] timeSplit = time.split(":");

        int hour = Integer.parseInt(timeSplit[0]);
        int minute = Integer.parseInt(timeSplit[1]);

        return LocalTime.of(hour, minute);
    }

    public static void saveAlarm(Alarm alarm) throws FileNotFoundException {
        listAlarms.add(alarm);
        Data.saveAlarms();
    }

    public static void checkAlarms() {
        ArrayList<Alarm> listAlarms = Alarm.listAlarms;

        if (listAlarms.size() > 0) {

            LocalDate todayDate = LocalDate.now();

            List<Alarm> todayAlarms = new ArrayList<>();

            listAlarms.forEach(alarm -> {
                if (alarm.getAlarmDate().equals(todayDate)) {
                    todayAlarms.add(alarm);
                }
            });

            if (todayAlarms.size() > 0) {
                LocalTime timeNow = LocalTime.now();
                AtomicBoolean condition = new AtomicBoolean(false);

                todayAlarms.forEach(alarm -> {
                    int minutesDifference = (int) timeNow.until(alarm.getAlarmTime(), ChronoUnit.MINUTES);

                    if (minutesDifference <= alarm.getMinutesBefore()) {
                        Task task = null;

                        for (Task e : Task.getListTask()) {
                            if (e.getIdTask() == alarm.getIdTask()) {
                                task = e;
                                break;
                            }
                        }
                        condition.set(true);
                        System.out.println("Sua tarefa " + task.getName() + " é hoje às " + alarm.getAlarmTime());
                    }
                });

                if(condition.get()) {
                    System.out.println("");
                    System.out.println("Aperte enter para continuar");
                    Scanner sc = new Scanner(System.in);
                    String enter = sc.nextLine();
                }
            }
        }
    }

    public static void clearAlarms() throws FileNotFoundException {
        ArrayList<Alarm> listAlarms = Data.loadAlarms();
        ArrayList<Task> listTasks = Data.loadTasks();

        ArrayList<Alarm> listAlarmsUpdated = new ArrayList<>();

        for(Task task : listTasks) {
            for(Alarm alarm : listAlarms) {
                if(alarm.getIdTask() == task.getIdTask()) {
                    listAlarmsUpdated.add(alarm);
                }
            }
        }

        Alarm.listAlarms = listAlarmsUpdated;
        Data.saveAlarms();
    }

    public int getIdTask() {
        return idTask;
    }

    public LocalDate getAlarmDate() {
        return alarmDate;
    }

    public LocalTime getAlarmTime() {
        return alarmTime;
    }

    public int getMinutesBefore() {
        return minutesBefore;
    }
}
