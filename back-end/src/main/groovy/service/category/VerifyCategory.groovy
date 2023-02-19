package service.category

class VerifyCategory {
    String verify(List<Category> categories, Integer indexCategory) {
        return categories.get(indexCategory).getCategory()
    }
}
