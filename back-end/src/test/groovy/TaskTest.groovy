import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import service.task.Task

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class TaskTest {

    @Test
    void DeveRetornarAConvertidaEmString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Task task1 = new Task("task1", "task1", "Casa", "A fazer", 5, LocalDate.parse("18/02/2023", formatter))

        String result = task1.getDateCreate()
        String expected = "18/02/2023"

        Assertions.assertEquals(expected, result)
    }

}
