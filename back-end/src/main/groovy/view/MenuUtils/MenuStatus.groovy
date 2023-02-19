package view.MenuUtils

import service.status.Status
import utils.ClearConsole

class MenuStatus {
    String menu(String message) {
        ClearConsole.clear()
        while(true) {
            println message
            println ""
            println "1 - A fazer"
            println "2 - Fazendo"
            println "3 - Feito"

            try {
                Scanner sc = new Scanner(System.in)
                String status = sc.nextLine()

                return new Status().verifyStatus(status)
            } catch (Exception ignored) {
                ClearConsole.clear()
                println "Opção inválida."
                println ""
            }
        }
    }
}
