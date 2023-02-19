import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import utils.ConvertStringInLocalDate
import utils.ConvertStringInLocalTime

import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class ConvertStringInLocalTimeTest {

    @Test
    void DeveConverterUmaStringEmLocalTime() {
        LocalTime result = new ConvertStringInLocalTime().convert("10:25")
        LocalTime expected = LocalTime.parse("10:25")

        Assertions.assertEquals(expected, result)
    }
}
