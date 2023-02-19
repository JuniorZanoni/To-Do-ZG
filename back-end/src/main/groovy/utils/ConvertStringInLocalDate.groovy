package utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class ConvertStringInLocalDate {
    LocalDate convert(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(date, formatter)
    }
}
