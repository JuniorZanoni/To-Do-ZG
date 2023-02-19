package service.Alarm

import java.time.LocalDate
import java.time.LocalTime

class Alarm {
    private String nameTask
    private LocalDate alarmDate
    private LocalTime alarmTime
    private int minutesBefore

    Alarm(String nameTask, LocalDate alarmDate, LocalTime alarmTime, int minutesBefore) {
        this.nameTask = nameTask
        this.alarmDate = alarmDate
        this.alarmTime = alarmTime
        this.minutesBefore = minutesBefore
    }

    String getNameTask() {
        return nameTask
    }

    LocalDate getAlarmDate() {
        return alarmDate
    }

    LocalTime getAlarmTime() {
        return alarmTime
    }

    int getMinutesBefore() {
        return minutesBefore
    }
}
