import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import service.priority.Priority

class PriorityTest {

    @Test
    void DeveRetornarCorretamenteUmaStringSeElaEstiverDentroDoRangeDaPrioridade() {
        Integer result = new Priority().verifyPriority("5")
        Integer expected = 5

        Assertions.assertEquals(expected, result)
    }

    @Test
    void NaoDeveRetornarUmaStringPorQueOValorNaoEstaDentroDoRangeDaPrioridade() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            new Priority().verifyPriority("8")
        })

        Assertions.assertEquals(null, thrown.getMessage())
    }

}
