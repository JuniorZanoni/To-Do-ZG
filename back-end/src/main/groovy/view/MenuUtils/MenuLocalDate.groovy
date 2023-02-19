package view.MenuUtils

import utils.ClearConsole
import utils.ConvertStringInLocalDate

import java.time.LocalDate

class MenuLocalDate {
    LocalDate menu(String message) {
        ClearConsole.clear()
        while(true) {
            println message
            println ""

            try {
                Scanner sc = new Scanner(System.in)
                String date = sc.nextLine()
                return new ConvertStringInLocalDate().convert(date)
            } catch (Exception ignored) {
                ClearConsole.clear()
                println "Formato inválido."
                println ""
            }
        }
    }
}
