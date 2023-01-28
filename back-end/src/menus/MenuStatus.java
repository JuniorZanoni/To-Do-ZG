package menus;

import utils.ClearConsole;

import java.util.Scanner;

public class MenuStatus {
    public String selectStatus() {
        ClearConsole.clear();

        System.out.println("Digite o número do status");
        System.out.println("0 - A fazer");
        System.out.println("1 - Fazendo");
        System.out.println("2 - Feito");

        Scanner scStatus = new Scanner(System.in);

        if (scStatus.hasNextInt()) {
            int status = scStatus.nextInt();

            if (status >= 0 && status <= 2) {
                switch (status) {
                    case 0:
                        return "A fazer";
                    case 1:
                        return "Fazendo";
                    default:
                        return "Feito";
                }
            } else {
                return selectStatus();
            }
        } else {
            return selectStatus();
        }
    }
}
