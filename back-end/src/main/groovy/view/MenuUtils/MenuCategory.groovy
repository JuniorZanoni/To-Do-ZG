package view.MenuUtils

import model.ModelCategory
import service.category.Category
import service.category.VerifyCategory
import utils.ClearConsole

class MenuCategory {
    List<Category> categories = new ModelCategory().getAllCategories()

    String menu(String message) {
        ClearConsole.clear()
        while(true) {
            println message
            println ""

            Integer counter = 0
            categories.forEach(category -> {
                println "${counter} - ${category.getCategory()}"
                counter++
            } )

            Scanner sc = new Scanner(System.in)

            try {
                Integer option = sc.nextInt()
                return new VerifyCategory().verify(categories, option)
            } catch (Exception ignored) {
                ClearConsole.clear()
                println "Opção inválida."
                println ""
            }
        }
    }
}
