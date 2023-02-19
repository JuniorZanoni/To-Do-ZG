package view.MenuUtils

import model.ModelTask
import service.task.ListTasks
import utils.ClearConsole

class MenuSelectTask {
    ListTasks listTasks = new ListTasks(new ModelTask().getAllTasks())

    Integer menu(String message) {
        while(true) {
            println message
            println ""

            Integer counter = 0
            listTasks.getListAllBO().forEach( e -> {
                println "${counter} - ${e.nome} - ${e.descricao} - ${e.categoria} - ${e.status} - ${e.prioridade}"
                counter ++
            })

            Scanner sc = new Scanner(System.in)

            try {
                Integer indexTask = sc.nextInt()
                listTasks.verifyTask(indexTask)
                return indexTask
            } catch (Exception ignored) {
                ClearConsole.clear()
                println "Opção inválida."
                println ""
            }
        }
    }
}
