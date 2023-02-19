import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import service.Alarm.Alarm
import service.Alarm.CheckAlarms
import service.task.ListTasks
import service.task.Task

import java.lang.reflect.Method
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class ListTasksTest {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    Task task1 = new Task("task1", "task1", "Casa", "A fazer", 5, LocalDate.parse("18/02/2023", formatter))
    Task task2 = new Task("task2", "task2", "Trabalho", "Feito", 4, LocalDate.parse("18/02/2023", formatter))
    Task task3 = new Task("task3", "task3", "Academia", "Fazendo", 3, LocalDate.parse("21/02/2023", formatter))
    List<Task> tasks = [task1, task2, task3]
    ListTasks listTasks = new ListTasks(tasks)

    @Test
    void DeveRetornarAListaDeTasksConvertida() {
        List<Map> result = listTasks.getListAllBO()
        List<Map> expected = [
                [nome: "task1", descricao: "task1", categoria: "Casa", status: "A fazer", prioridade: 5],
                [nome: "task2", descricao: "task2", categoria: "Trabalho", status: "Feito", prioridade: 4],
                [nome: "task3", descricao: "task3", categoria: "Academia", status: "Fazendo", prioridade: 3]
        ]

        Assertions.assertEquals(expected, result)
    }

    @Test
    void DeveRetornarAListaFiltradaPorCategoria() {
        List<Map> result = listTasks.getListByCategoryBO("Casa")
        List<Map> expected = [
                [nome: "task1", descricao: "task1", categoria: "Casa", status: "A fazer", prioridade: 5],
        ]

        Assertions.assertEquals(expected, result)
    }

    @Test
    void DeveRetornarAListaFiltradaPorPrioridade() {
        List<Map> result = listTasks.getListByPriorityBO(5)
        List<Map> expected = [
                [nome: "task1", descricao: "task1", categoria: "Casa", status: "A fazer", prioridade: 5],
        ]

        Assertions.assertEquals(expected, result)
    }

    @Test
    void DeveRetornarAListaFiltradaPorStatus() {
        List<Map> result = listTasks.getListByStatusBO("A fazer")
        List<Map> expected = [
                [nome: "task1", descricao: "task1", categoria: "Casa", status: "A fazer", prioridade: 5],
        ]

        Assertions.assertEquals(expected, result)
    }

    @Test
    void DeveRetornarAListaFiltradaPorData() {
        List<Map> result = listTasks.getListByDateBO("18/02/2023")
        List<Map> expected = [
                [nome: "task1", descricao: "task1", categoria: "Casa", status: "A fazer", prioridade: 5],
                [nome: "task2", descricao: "task2", categoria: "Trabalho", status: "Feito", prioridade: 4]
        ]

        Assertions.assertEquals(expected, result)
    }

    @Test
    void DeveLevantarUmaExceptionPorQueOIndexNaoExisteNaLista() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            listTasks.verifyTask(4);
        });

        Assertions.assertEquals("Index: 4, Size: 3", thrown.getMessage());
    }
}
