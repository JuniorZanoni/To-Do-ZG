package view.MenuCreateCategory

import model.ModelCategory
import service.category.Category
import utils.ClearConsole

class MenuCreateCategory {

    void menu() {
        ClearConsole.clear()
        println "Digite o nome da categoria."
        Scanner sc = new Scanner(System.in)
        String value = sc.nextLine()

        Category category = new Category(value)
        new ModelCategory().save(category)
        ClearConsole.clear()
    }
}
