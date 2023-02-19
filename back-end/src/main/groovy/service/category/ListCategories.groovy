package service.category

class ListCategories {

    List<Category> listCategories

    ListCategories(List<Category> listCategories) {
        this.listCategories = listCategories
    }

    List<Map> getAllList() {
        List<Map> list = []

        listCategories.forEach {category -> {
            list.add([
                    nome: category.getCategory()
            ])
        }}

        return list
    }
}
