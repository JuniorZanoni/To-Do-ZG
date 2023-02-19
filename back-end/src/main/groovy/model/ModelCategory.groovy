package model

import service.category.Category

class ModelCategory {

    void save(Category category) {
        List<Category> listCategories = getAllCategories()
        listCategories.add(category)
        saveAllCategories(listCategories)
    }

    List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>()

        try {
            Scanner scanner = new Scanner(new File("categories.csv"))

            while (scanner.hasNextLine()) {
                String nameCategory = scanner.nextLine()
                Category category = new Category(nameCategory)
                categories.add(category)
            }

            scanner.close()
        } catch (Exception ignored) {
            return []
        }

        return categories
    }

     private void saveAllCategories(List<Category> listCategories) {
        PrintStream ps = new PrintStream("categories.csv")

        listCategories.forEach(element -> {
            ps.print(element.getCategory())
            ps.println()
        })

        ps.close()
    }
}
