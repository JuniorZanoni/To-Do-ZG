package view.MenuListTasks

import service.category.ListCategories
import service.task.ListTasks
import utils.ClearConsole

class MenuListTasksByDate {
    ListTasks listTasks
    ListCategories listCategories

    MenuListTasksByDate(ListTasks listTasks, ListCategories listCategories) {
        this.listTasks = listTasks
        this.listCategories = listCategories
    }

    void menu() {
        boolean condition = true
        while(condition) {
            println "Digite a data no formato dd/mm/yyyy."
            println ""

            Scanner sc = new Scanner(System.in)

            try {
                String data = sc.nextLine()

                ClearConsole.clear()
                listTasks.getListByDateBO(data).forEach { println "${it.nome} - ${it.descricao} - ${it.categoria} - ${it.status} - ${it.prioridade}"}
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
