import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import service.category.Category
import service.category.ListCategories
import service.category.VerifyCategory

class ListCategoriesTest {

    @Test
    void DeveRetornarCorretamenteAListaDeCategorias() {
        Category category1 = new Category("Casa")
        Category category2 = new Category("Trabalho")
        List<Category> categories = [category1, category2]
        ListCategories listCategories = new ListCategories(categories)

        List<Map> result = listCategories.getAllList()
        List<Map> expected = [[nome: "Casa"], [nome: "Trabalho"]]

        Assertions.assertEquals(expected, result)
    }

    @Test
    void DeveRetornarCorretamenteACategoriaCorrespondenteAoIndex() {
        Category category1 = new Category("Casa")
        Category category2 = new Category("Trabalho")
        List<Category> categories = [category1, category2]

        String result = new VerifyCategory().verify(categories, 0)
        String expected = "Casa"

        Assertions.assertEquals(expected, result)
    }

    @Test
    void DeveLevantarUmaExceptionPorQueACategoriaNaoExiste() {
        Category category1 = new Category("Casa")
        List<Category> categories = [category1]

        IndexOutOfBoundsException thrown = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            new VerifyCategory().verify(categories, 1)
        })

        Assertions.assertEquals("Index: 1, Size: 1", thrown.getMessage())
    }
}
