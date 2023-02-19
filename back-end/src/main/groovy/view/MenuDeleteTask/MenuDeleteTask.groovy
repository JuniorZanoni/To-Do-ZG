package view.MenuDeleteTask

import model.ModelTask
import service.task.ListTasks
import service.task.Task
import utils.ClearConsole
import view.MenuUtils.MenuSelectTask

class MenuDeleteTask {
    void menu() {
        List<Task> listTasks = new ModelTask().getAllTasks()
        if(listTasks.isEmpty()) {
            ClearConsole.clear()
            println "Você não tem nenhuma tarefa cadastrada."
            println ""
        } else {
            Integer indexTask = new MenuSelectTask().menu("Digite o número da tarefa que deseja excluir.")
            new ModelTask().delete(indexTask)
            ClearConsole.clear()
        }
    }
}
