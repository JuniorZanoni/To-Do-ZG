package view.MenuUtils

import utils.ClearConsole
import utils.ConvertStringInLocalTime

import java.time.LocalTime

class MenuLocalTime {
    LocalTime menu(String message) {
        ClearConsole.clear()
        while(true) {
            println message
            println ""

            try {
                Scanner sc = new Scanner(System.in)
                String time = sc.nextLine()
                return new ConvertStringInLocalTime().convert(time)
            } catch (Exception ignored) {
                ClearConsole.clear()
                println "Formato inválido."
                println ""
            }
        }
    }
}
