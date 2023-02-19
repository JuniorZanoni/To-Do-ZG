package view.MenuListTasks

import service.category.ListCategories
import service.task.ListTasks
import utils.ClearConsole

class MenuListTasksByCategory {
    ListTasks listTasks
    ListCategories listCategories

    MenuListTasksByCategory(ListTasks listTasks, ListCategories listCategories) {
        this.listTasks = listTasks
        this.listCategories = listCategories
    }

    void menu() {
        boolean condition = true
        while(condition) {
            println "Digite o número da categoria."
            println ""

            def categories = listCategories.getAllList()

            Integer counter = 0
            categories.forEach(category -> {
                println "${counter} - ${category.nome}"
                counter++
            })

            Scanner sc = new Scanner(System.in)
            String option = sc.nextLine()

            try {
                String category = categories.get(option.toInteger()).nome

                ClearConsole.clear()
                listTasks.getListByCategoryBO(category).forEach { println "${it.nome} - ${it.descricao} - ${it.categoria} - ${it.status} - ${it.prioridade}"}
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
