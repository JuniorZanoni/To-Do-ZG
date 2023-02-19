package view.MenuEditTask

import model.ModelTask
import service.task.Task
import view.MenuUtils.MenuCategory

class MenuEditCategory {
    void menu(Integer indexTask) {
        ModelTask modelTask = new ModelTask()
        Task task = modelTask.getTaskById(indexTask)

        String category = new MenuCategory().menu("Digite o número da nova categoria.")
        task.category = category

        modelTask.update(task, indexTask)
    }
}
