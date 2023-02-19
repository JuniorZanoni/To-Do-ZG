package model

import service.Alarm.Alarm

import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class ModelAlarm {

    void save(Alarm alarm) {
        List<Alarm> listAlarms = getAllAlarms()
        listAlarms.add(alarm)
        saveAllAlarms(listAlarms)
    }

    List<Alarm> getAllAlarms() {
        List<Alarm> alarms = new ArrayList<>()

        try {
            Scanner scanner = new Scanner(new File("alarms.csv"))

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine()
                List<String> values = line.split(",")

                String nameTask = values[0]
                LocalDate alarmDate = LocalDate.parse(values[1])
                LocalTime alarmTime = LocalTime.parse(values[2])

                Integer minuteBefore = values[3].toInteger()

                Alarm alarm = new Alarm(nameTask, alarmDate, alarmTime, minuteBefore)

                alarms.add(alarm)
            }

            scanner.close()
        } catch (Exception e) {
            e.printStackTrace()
            return []
        }

        return alarms
    }

    void saveAllAlarms(ArrayList<Alarm> listAlarms) {
        PrintStream ps = new PrintStream("alarms.csv");

        listAlarms.forEach(alarm -> {
            ps.print(alarm.getNameTask());
            ps.print(",");
            ps.print(alarm.getAlarmDate());
            ps.print(",");
            ps.print(alarm.getAlarmTime());
            ps.print(",");
            ps.print(alarm.getMinutesBefore());
            ps.println();
        });

        ps.close();
    }
}
