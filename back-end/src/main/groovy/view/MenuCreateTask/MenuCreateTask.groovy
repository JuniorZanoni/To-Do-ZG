package view.MenuCreateTask

import model.ModelCategory
import model.ModelTask
import service.category.Category
import service.task.Input
import service.task.Task
import service.task.TypesInput
import utils.ClearConsole
import view.MenuUtils.MenuCategory
import view.MenuUtils.MenuPriority
import view.MenuUtils.MenuStatus

import java.time.LocalDate

class MenuCreateTask {

    void menu() {
        List<Category> categories = new ModelCategory().getAllCategories()

        if(categories.isEmpty()) {
            ClearConsole.clear()
            println "Você não tem nenhuma categoria cadastrada."
            println ""
        } else {
            String nome = createInput("Digite o nome da tarefa.", TypesInput.NOME)
            String descricao = createInput("Digite a descrição da tarefa.", TypesInput.NOME)
            Integer prioridade = new MenuPriority().menu("Digite a prioridade da tarefa de 1 a 5.")
            String status = new MenuStatus().menu("Digite o número do status da tarefa.")
            String categoria = new MenuCategory().menu("Digite o número da categoria.")

            Task task = new Task(nome, descricao, categoria, status, prioridade, LocalDate.now())
            new ModelTask().save(task)
            ClearConsole.clear()
        }
    }

    private createInput(String message, TypesInput type) {
        ClearConsole.clear()
        println message
        Scanner sc = new Scanner(System.in)
        String value = sc.nextLine()

        switch(type) {
            case TypesInput.NOME:
                return Input.inputNome(value)
            case TypesInput.DESCRICAO:
                return Input.inputDescricao(value)
        }
    }
}
