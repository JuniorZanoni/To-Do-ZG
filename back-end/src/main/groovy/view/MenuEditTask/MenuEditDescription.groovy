package view.MenuEditTask

import model.ModelTask
import service.task.Task

class MenuEditDescription {
    void menu(Integer indexTask) {
        ModelTask modelTask = new ModelTask()
        Task task = modelTask.getTaskById(indexTask)

        println "Digite a nova descrição."
        Scanner sc = new Scanner(System.in)
        task.description = sc.nextLine()

        modelTask.update(task, indexTask)
    }
}
