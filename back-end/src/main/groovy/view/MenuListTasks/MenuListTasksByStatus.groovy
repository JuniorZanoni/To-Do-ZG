package view.MenuListTasks

import service.category.ListCategories
import service.task.ListTasks
import utils.ClearConsole

class MenuListTasksByStatus {
    ListTasks listTasks
    ListCategories listCategories

    MenuListTasksByStatus(ListTasks listTasks, ListCategories listCategories) {
        this.listTasks = listTasks
        this.listCategories = listCategories
    }

    void menu() {
        boolean condition = true
        while(condition) {
            println "Digite o número do status."
            println ""
            println "0 - A fazer."
            println "1 - Fazendo."
            println "2 - Feito."

            Scanner sc = new Scanner(System.in)

            try {
                Integer option = sc.nextLine().toInteger()
                List status = ["A fazer", "Fazendo", "Feito"]

                ClearConsole.clear()
                listTasks.getListByStatusBO(status.get(option)).forEach { println "${it.nome} - ${it.descricao} - ${it.categoria} - ${it.status} - ${it.prioridade}"}
                println ""
                condition = false
            } catch (Exception ignored) {
                ClearConsole.clear()
                println "Opção inválida."
                println ""
            }
        }
    }
}
