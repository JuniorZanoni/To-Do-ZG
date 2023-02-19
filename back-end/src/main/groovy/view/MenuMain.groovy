package view

import model.ModelAlarm
import service.Alarm.Alarm
import service.Alarm.CheckAlarms
import utils.ClearConsole
import view.MenuCreateAlarm.MenuCreateAlarm
import view.MenuCreateCategory.MenuCreateCategory
import view.MenuCreateTask.MenuCreateTask
import view.MenuDeleteTask.MenuDeleteTask
import view.MenuEditTask.MenuEditTask
import view.MenuListTasks.MenuListTask

class MenuMain {
    static void main(String[] args) {
        ClearConsole.clear()

        List<Alarm> alarms = new CheckAlarms().checkAlarms(new ModelAlarm().getAllAlarms())
        alarms.forEach( alarm -> {
            println "A sua tarefa ${alarm.getNameTask()} é hoje às ${alarm.getAlarmTime()}."
            println ""
            println "Pressione enter para continuar."
            Scanner sc = new Scanner(System.in)
            String next = sc.nextLine()
            ClearConsole.clear()
        })

        boolean condition = true
        while (condition) {
            println "1 - Listar tarefas."
            println "2 - Criar tarefa."
            println "3 - Editar tarefa."
            println "4 - Deletar tarefa."
            println "5 - Criar categoria."
            println "6 - Criar alarme."
            println ""
            println "0 - Sair."

            Scanner sc = new Scanner(System.in)
            String option = sc.nextLine()

            switch(option) {
                case "1":
                    ClearConsole.clear()
                    new MenuListTask().menu()
                    break
                case "2":
                    ClearConsole.clear()
                    new MenuCreateTask().menu()
                    break
                case "3":
                    ClearConsole.clear()
                    new MenuEditTask().menu()
                    break
                case "4":
                    ClearConsole.clear()
                    new MenuDeleteTask().menu()
                    break
                case "5":
                    ClearConsole.clear()
                    new MenuCreateCategory().menu()
                    break
                case "6":
                    ClearConsole.clear()
                    new MenuCreateAlarm().menu()
                    break
                case "0":
                    ClearConsole.clear()
                    condition = false
                    break
                default:
                    ClearConsole.clear()
                    println "Opção inválida."
                    println ""
            }
        }
    }
}
