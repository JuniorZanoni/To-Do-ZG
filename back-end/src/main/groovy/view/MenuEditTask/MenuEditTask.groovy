package view.MenuEditTask

import model.ModelTask
import service.task.Task
import utils.ClearConsole
import view.MenuUtils.MenuSelectTask

class MenuEditTask {
    void menu() {
        List<Task> listTasks = new ModelTask().getAllTasks()
        if(listTasks.isEmpty()) {
            ClearConsole.clear()
            println "Você não tem nenhuma tarefa cadastrada."
            println ""
        } else {
            Integer indexTask = new MenuSelectTask().menu("Digite o número da tarefa que deseja editar.")
            ClearConsole.clear()
            Boolean condition = true
            while (condition) {
                println "1 - Editar nome."
                println "2 - Editar descrição."
                println "3 - Editar prioridade."
                println "4 - Editar status."
                println "5 - Editar categoria."

                Scanner sc = new Scanner(System.in)
                String option = sc.nextLine()

                switch (option) {
                    case "1":
                        ClearConsole.clear()
                        new MenuEditName().menu(indexTask)
                        ClearConsole.clear()
                        condition = false
                        break;
                    case "2":
                        ClearConsole.clear()
                        new MenuEditDescription().menu(indexTask)
                        ClearConsole.clear()
                        condition = false
                        break;
                    case "3":
                        ClearConsole.clear()
                        new MenuEditPriority().menu(indexTask)
                        ClearConsole.clear()
                        condition = false
                        break;
                    case "4":
                        ClearConsole.clear()
                        new MenuEditStatus().menu(indexTask)
                        ClearConsole.clear()
                        condition = false
                        break;
                    case "5":
                        ClearConsole.clear()
                        new MenuEditCategory().menu(indexTask)
                        ClearConsole.clear()
                        condition = false
                        break;
                    default:
                        ClearConsole.clear()
                        println "Opção inválida."
                        println ""
                }
            }
        }
    }
}
