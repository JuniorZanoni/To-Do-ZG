import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import utils.ConvertStringInLocalDate

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class ConvertStringInLocalDateTest {

    @Test
    void DeveConverterUmaStringEmLocalDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate result = new ConvertStringInLocalDate().convert("18/02/2023")
        LocalDate expected = LocalDate.parse("18/02/2023", formatter)

        Assertions.assertEquals(expected, result)
    }
}
