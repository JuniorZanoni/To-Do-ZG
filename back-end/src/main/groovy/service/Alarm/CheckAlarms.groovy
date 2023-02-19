package service.Alarm

import java.time.LocalDate
import java.time.LocalTime

class CheckAlarms {
    List<Alarm> checkAlarms(List<Alarm> alarms) {
        List<Alarm> alarmsToday = checkDate(alarms)
        return checkTime(alarmsToday)
    }

    private List<Alarm> checkDate(List<Alarm> alarms) {
        LocalDate today = LocalDate.now()
        return alarms.findAll(alarm -> alarm.getAlarmDate() == today)
    }

    private List<Alarm> checkTime(List<Alarm> alarms) {
        Integer minutesTimeNow = convertLocalTimeInMinutes(LocalTime.now())

        return alarms.findAll(alarm -> {
            Integer minutesForAlarm = convertLocalTimeInMinutes(alarm.getAlarmTime())
            return ((minutesForAlarm - minutesTimeNow) < alarm.getMinutesBefore()) && ((minutesForAlarm - minutesTimeNow ) > 0)
        })
    }

   private Integer convertLocalTimeInMinutes(LocalTime time) {
        Integer hours = time.getHour()
        Integer minutes = time.getMinute()
        return (hours * 60) + minutes
    }
}
