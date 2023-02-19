package view.MenuListTasks

import model.ModelCategory
import model.ModelTask
import service.category.ListCategories
import service.task.ListTasks
import utils.ClearConsole

class MenuListTask {
    ListTasks listTasks = new ListTasks(new ModelTask().getAllTasks())
    ListCategories listCategories = new ListCategories(new ModelCategory().getAllCategories())

    void menu() {
        boolean condition = true
        if(listTasks.getListTasks().isEmpty()) {
            condition = false
            ClearConsole.clear()
            println "Você não tem nenhuma tarefa cadastrada."
            println ""
        }

        while (condition) {
            println "1 - Listar todas tarefas."
            println "2 - Listar por categoria."
            println "3 - Listar por prioridade."
            println "4 - Listar por status."
            println "5 - Listar por data."
            println ""
            println "0 - Voltar."

            Scanner sc = new Scanner(System.in)
            String option = sc.nextLine()

            switch (option) {
                case "0":
                    ClearConsole.clear()
                    condition = false
                    break
                case "1":
                    ClearConsole.clear()
                    new MenuListAllTasks(listTasks).menu()
                    println ""
                    break
                case "2":
                    ClearConsole.clear()
                    new MenuListTasksByCategory(listTasks, listCategories).menu()
                    println ""
                    break
                case "3":
                    ClearConsole.clear()
                    new MenuListTasksByPriority(listTasks, listCategories).menu()
                    println ""
                    break
                case "4":
                    ClearConsole.clear()
                    new MenuListTasksByStatus(listTasks, listCategories).menu()
                    println ""
                    break
                case "5":
                    ClearConsole.clear()
                    new MenuListTasksByDate(listTasks, listCategories).menu()
                    println ""
                    break
                default:
                    ClearConsole.clear()
                    println "Opção inválida"
                    println ""
            }
        }
    }
}
