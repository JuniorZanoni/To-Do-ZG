package view.MenuCreateAlarm

import utils.ClearConsole
import utils.ConvertStringInLocalTime

class MenuteMinutesBefore {
    Integer menu(String message) {
        ClearConsole.clear()
        while(true) {
            println message
            println ""

            try {
                Scanner sc = new Scanner(System.in)
                Integer time = sc.nextInt()
                return time
            } catch (Exception ignored) {
                ClearConsole.clear()
                println "Formato inválido."
                println ""
            }
        }
    }
}
