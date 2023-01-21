package menus;

import utils.ClearConsole;

import java.util.Scanner;

public class MenuPriority {

    public int selectPriority() {
        ClearConsole.clear();
        System.out.println("Digite uma prioridade entre 1 e 5");
        Scanner scPriority = new Scanner(System.in);

        if (scPriority.hasNextInt()) {
            int priority = scPriority.nextInt();

            if (priority <= 5 && priority > 0) {
                return priority;
            } else {
                return selectPriority();
            }

        } else {
            return selectPriority();
        }
    }
}
