package menus;

import data.Data;
import tasks.Category;
import utils.ClearConsole;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuCategory {

    public static void createCategory() throws FileNotFoundException, ParseException {
        ClearConsole.clear();
        System.out.println("Digite o nome da categoria que deseja criar");

        Scanner scNameCategory = new Scanner(System.in);
        String nameCategory = scNameCategory.nextLine();

        Category.save(nameCategory);
        Data.saveCategorys();

        ClearConsole.clear();
        System.out.println("Categoria cadastrada com sucesso");
        MenuPrincipal.menu();
    }

    public static String listCategory() {
        ClearConsole.clear();
        System.out.println("Digite o número da categoria");

        ArrayList<String> listCategories = Category.getListCategory();

        for (int i = 0; i < listCategories.size(); i++) {
            System.out.println(i + " - " + listCategories.get(i));
        }

        Scanner scCategory = new Scanner(System.in);

        if (scCategory.hasNextInt()) {
            int idCategory = scCategory.nextInt();

            if (idCategory <= listCategories.size() - 1 && idCategory >= 0) {
                return listCategories.get(idCategory);
            } else {
                return listCategory();
            }
        } else {
            return listCategory();
        }

    }
}
