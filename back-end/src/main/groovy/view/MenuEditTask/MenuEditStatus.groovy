package view.MenuEditTask

import model.ModelTask
import service.task.Task
import view.MenuUtils.MenuStatus

class MenuEditStatus {
    void menu(Integer indexTask) {
        ModelTask modelTask = new ModelTask()
        Task task = modelTask.getTaskById(indexTask)

        String status = new MenuStatus().menu("Digite um número do novo status.")
        task.status = status

        modelTask.update(task, indexTask)
    }
}
