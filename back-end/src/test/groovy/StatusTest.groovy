import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import service.status.Status

class StatusTest {

    @Test
    void DeveRetornarAStringCorrespondenteAoStatusPassado() {
        String result = new Status().verifyStatus("3")
        String expected = "Feito"

        Assertions.assertEquals(expected, result)
    }

    @Test
    void DeveLevantarUmaExceptionPorQueOValorPassadoNaoExisteNoSwitch() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            new Status().verifyStatus("4")
        })

        Assertions.assertEquals(null, thrown.getMessage())
    }
}
