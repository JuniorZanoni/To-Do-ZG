package view.MenuUtils

import service.priority.Priority
import utils.ClearConsole

class MenuPriority {
    Integer menu(String message) {
        ClearConsole.clear()
        while(true) {
            println message
            println ""

            try {
                Scanner sc = new Scanner(System.in)
                String priority = sc.nextLine()

                return new Priority().verifyPriority(priority)
            } catch (Exception ignored) {
                ClearConsole.clear()
                println "Opção inválida."
                println ""
            }
        }
    }
}
