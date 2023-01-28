package tasks;

import data.Data;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Category {
    private static ArrayList<String> listCategory;

    static {
        try {
            listCategory = Data.loadCategorys();
        } catch (FileNotFoundException e) {
            listCategory = new ArrayList<String>();
        }
    }

    public static void save(String string) {
        listCategory.add(string);
    }

    public static ArrayList<String> getListCategory() {
        return listCategory;
    }

    public static String verifyCategory(int indexCategory) {
        if (indexCategory + 1 > listCategory.size() || indexCategory < 0) {
            System.out.println("Opção inválida, tente novamente");
            return "False";
        } else {
            return listCategory.get(indexCategory);
        }
    }
}
