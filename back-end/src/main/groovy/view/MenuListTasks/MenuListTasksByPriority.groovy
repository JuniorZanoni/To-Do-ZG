package view.MenuListTasks

import service.category.ListCategories
import service.task.ListTasks
import utils.ClearConsole
import view.MenuUtils.MenuPriority

class MenuListTasksByPriority {
    ListTasks listTasks
    ListCategories listCategories

    MenuListTasksByPriority(ListTasks listTasks, ListCategories listCategories) {
        this.listTasks = listTasks
        this.listCategories = listCategories
    }

    void menu() {
        boolean condition = true
        while(condition) {
            Integer priority = new MenuPriority().menu("Digite uma prioridade de 1 a 5.")

            ClearConsole.clear()
            listTasks.getListByPriorityBO(priority).forEach { println "${it.nome} - ${it.descricao} - ${it.categoria} - ${it.status} - ${it.prioridade}"}
            println ""
            condition = false
        }
    }

}
