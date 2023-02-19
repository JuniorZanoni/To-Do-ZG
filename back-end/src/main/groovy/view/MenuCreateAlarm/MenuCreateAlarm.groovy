package view.MenuCreateAlarm

import model.ModelAlarm
import model.ModelTask
import service.Alarm.Alarm
import service.task.Task
import utils.ClearConsole
import view.MenuUtils.MenuLocalDate
import view.MenuUtils.MenuLocalTime
import view.MenuUtils.MenuSelectTask

import java.time.LocalDate
import java.time.LocalTime

class MenuCreateAlarm {
    void menu() {
        List<Task> listTasks = new ModelTask().getAllTasks()
        if(listTasks.isEmpty()) {
            ClearConsole.clear()
            println "Você não tem nenhuma tarefa cadastrada."
            println ""
        } else {
            Integer taskIndex = new MenuSelectTask().menu("Digite o número da tarefa que deseja criar o alarme.")
            LocalDate alarmDate = new MenuLocalDate().menu("Digite a data do alarme no formato dd/mm/aaaa.")
            LocalTime alarmTime = new MenuLocalTime().menu("Digite a hora do alarme no formaro hh:mm.")
            Integer minutesBefore = new MenuteMinutesBefore().menu("Digite quantos minutos antes do alarme quer ser avisado.")

            Task task = new ModelTask().getTaskById(taskIndex)

            Alarm alarm = new Alarm(task.name, alarmDate, alarmTime, minutesBefore)
            new ModelAlarm().save(alarm)
            ClearConsole.clear()
        }
    }
}
