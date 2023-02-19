package view.MenuEditTask

import model.ModelTask
import service.task.Task

class MenuEditName {
    void menu(Integer indexTask) {
        ModelTask modelTask = new ModelTask()
        Task task = modelTask.getTaskById(indexTask)

        println "Digite o novo nome."
        Scanner sc = new Scanner(System.in)
        task.name = sc.nextLine()

        modelTask.update(task, indexTask)
    }
}
