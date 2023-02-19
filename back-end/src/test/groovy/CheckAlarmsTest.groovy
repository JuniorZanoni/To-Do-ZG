import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import service.Alarm.Alarm
import service.Alarm.CheckAlarms

import java.lang.reflect.Method
import java.time.LocalDate
import java.time.LocalTime

class CheckAlarmsTest {

    @Test
    void DeveConverterCorretamenteLocalTimeEmMinutesInteger() {
        Method method = CheckAlarms.class.getDeclaredMethod("convertLocalTimeInMinutes", LocalTime.class);
        method.setAccessible(true);

        Integer result = (Integer)method.invoke(new CheckAlarms(), LocalTime.parse("10:30"));
        Integer expected = 630

        Assertions.assertEquals(expected, result)
    }

    @Test
    void DeveRetornarCorretamenteUmaListaDeAlarmesComOTempoDeDespertar() {
        Alarm alarm1 = new Alarm("tarefa1", LocalDate.now(), LocalTime.now().plusMinutes(20), 30)
        Alarm alarm2 = new Alarm("tarefa2", LocalDate.now(), LocalTime.now().plusMinutes(50), 10)
        Alarm alarm3 = new Alarm("tarefa3", LocalDate.now(), LocalTime.now().plusMinutes(60), 100)
        List<Alarm> listAlarms = [alarm1, alarm2, alarm3]

        Method method = CheckAlarms.class.getDeclaredMethod("checkTime", List<Alarm>.class);
        method.setAccessible(true);

        List<Alarm> result = (List<Alarm>)method.invoke(new CheckAlarms(), listAlarms);
        List<Alarm> expected = [alarm1, alarm3]

        Assertions.assertEquals(expected, result)
    }

    @Test
    void DeveRetornarCorretamenteUmaListaDeAlarmesComAsDatasDeDespertar() {
        Alarm alarm1 = new Alarm("tarefa1", LocalDate.now(), LocalTime.now(), 30)
        Alarm alarm2 = new Alarm("tarefa2", LocalDate.now(), LocalTime.now(), 10)
        Alarm alarm3 = new Alarm("tarefa3", LocalDate.now().plusDays(2), LocalTime.now(), 100)
        List<Alarm> listAlarms = [alarm1, alarm2, alarm3]

        Method method = CheckAlarms.class.getDeclaredMethod("checkDate", List<Alarm>.class);
        method.setAccessible(true);

        List<Alarm> result = (List<Alarm>)method.invoke(new CheckAlarms(), listAlarms);
        List<Alarm> expected = [alarm1, alarm2]

        Assertions.assertEquals(expected, result)
    }

    @Test
    void DeveRetornarCorretamenteUmaListaDeAlarmesComAsDatasEHorarioDeDespertar() {
        Alarm alarm1 = new Alarm("tarefa1", LocalDate.now(), LocalTime.now().plusMinutes(60), 30)
        Alarm alarm2 = new Alarm("tarefa2", LocalDate.now(), LocalTime.now().plusMinutes(15), 20)
        Alarm alarm3 = new Alarm("tarefa3", LocalDate.now().plusDays(2), LocalTime.now(), 100)
        List<Alarm> listAlarms = [alarm1, alarm2, alarm3]

        Method method = CheckAlarms.class.getDeclaredMethod("checkAlarms", List<Alarm>.class);
        method.setAccessible(true);

        List<Alarm> result = (List<Alarm>)method.invoke(new CheckAlarms(), listAlarms);
        List<Alarm> expected = [alarm2]

        Assertions.assertEquals(expected, result)
    }
}
