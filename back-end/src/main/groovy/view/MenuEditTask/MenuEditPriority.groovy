package view.MenuEditTask

import model.ModelTask
import service.task.Task
import view.MenuUtils.MenuPriority

class MenuEditPriority {
    void menu(Integer indexTask) {
        ModelTask modelTask = new ModelTask()
        Task task = modelTask.getTaskById(indexTask)

        Integer priority = new MenuPriority().menu("Digite um número de 1 a 5 para a nova prioridade.")
        task.priority = priority

        modelTask.update(task, indexTask)
    }
}
